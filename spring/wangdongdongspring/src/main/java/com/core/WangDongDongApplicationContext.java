package com.core;


import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 容器
 */
public class WangDongDongApplicationContext {

    /**
     * 配置文件
     */
    private Class configClass;


    /**
     *  beanDefinition
     */
    private Map<String,BeanDefinition> beanDefinitionMap=new HashMap<>();

    /**
     * 单例池
     */
    private Map<String,Object> singletonObjects = new HashMap<>();

    /**
     * 后置处理器
     */
    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();


    /**
     * spring 启动
     * @param configClass
     */
    public WangDongDongApplicationContext(Class configClass) {
        this.configClass = configClass;

        // beanDefinition
        scan(configClass);

        // 实例化单例---》单例池
        preInstantiateSingletons();

    }

    private void preInstantiateSingletons() {
        for(Map.Entry<String,BeanDefinition> entry:beanDefinitionMap.entrySet()){
            BeanDefinition beanDefinition=entry.getValue();
            String beanName =entry.getKey();
            if(beanDefinition.getScope().endsWith("singleton")){
                // 创建单例bean
                Object bean= createBean(beanName,beanDefinition);
                singletonObjects.put(beanName,bean);

            }
        }
    }

    /**
     * 创建bean
     * @param beanName
     * @param beanDefinition
     * @return
     */
    private Object createBean(String beanName,BeanDefinition beanDefinition){

        try {
            Class clazz = beanDefinition.getClazz();
            Object instance = clazz.newInstance();

            // 依赖注入
            for(Field field: clazz.getDeclaredFields()){
                if(field.isAnnotationPresent(Autowired.class)){
                    String fieldName =field.getName();
                    Object o = getBean(fieldName);
                    field.setAccessible(true);
                    field.set(instance,o);
                }
            }

            //初始化前
            for(BeanPostProcessor beanPostProcessor:beanPostProcessorList){
                instance=beanPostProcessor.postProcessBeforeInitialization(instance,beanName);
            }

            // 初始化
            if(instance instanceof InitializingBean){
                try {
                    ((InitializingBean)instance).afterPropertiesSet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //初始化后
            for(BeanPostProcessor beanPostProcessor:beanPostProcessorList){
                instance=beanPostProcessor.postProcessAfterInitialization(instance,beanName);
            }

            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        throw new RuntimeException();
    }

    private void scan(Class configClass) {
        //解析配置类
        ComponentScan annotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
        //扫描路径(com.test)
        String path = annotation.value();
        System.out.println(path);
        //com/test
        path = path.replace(".","/");

        //扫描类 -- 找到Component注解的类-->生成Bean对象
        ClassLoader loader =WangDongDongApplicationContext.class.getClassLoader();
        URL resource = loader.getResource(path);
        File file = new File(resource.getFile());
        File[] files =file.listFiles();
        for (File f:files){
            // E:\2023\2023_mianshi\spring\wangdongdongspring\target\classes\com\test\UserService.class
            String fileName =f.getAbsolutePath();
            System.out.println(fileName);
            if(fileName.endsWith(".class")){
                String className =fileName.substring(fileName.indexOf("com"),fileName.indexOf(".class"));
                // com\test\UserService
                System.out.println(className);
                className = className.replace("\\",".");

                try {
                    // 加载类
                    Class clazz =loader.loadClass(className);
                    if(clazz.isAnnotationPresent(Component.class)){
                        System.out.println("加载到有Component注解的类:"+clazz);

                        // 判断是不是后置处理器，是后置处理器就加入到后置处理器list中
                        if(BeanPostProcessor.class.isAssignableFrom(clazz)){
                            BeanPostProcessor o = (BeanPostProcessor) clazz.newInstance();
                            beanPostProcessorList.add(o);
                        }

                        // BeanDefinition
                        Component clazzAnnotation= (Component) clazz.getAnnotation(Component.class);
                        String beanName=clazzAnnotation.value();


                        BeanDefinition beanDefinition = new BeanDefinition();
                        beanDefinition.setClazz(clazz);
                        if(clazz.isAnnotationPresent(Scope.class)){
                            Scope clazzAnnotation2= (Scope) clazz.getAnnotation(Scope.class);
                            beanDefinition.setScope(clazzAnnotation2.value());
                        }else{
                            beanDefinition.setScope("singleton");
                        }
                        beanDefinitionMap.put(beanName,beanDefinition);


                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public Object getBean(String beanName){  /// beanName --->map--->BeanDefinition对象----scope
        if(beanDefinitionMap.containsKey(beanName)){
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if(beanDefinition.getScope().endsWith("singleton")){
                // 单例
                Object o =singletonObjects.get(beanName);
                return o;
            }else{
                // 多例
                Object o = createBean(beanName,beanDefinition);
                return o;
            }
        }else{
            throw new NullPointerException();
        }

    }
}
