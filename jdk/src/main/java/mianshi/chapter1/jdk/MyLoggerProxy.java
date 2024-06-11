package mianshi.chapter1.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyLoggerProxy {
    private Object target;//被代理的目标对象

    public MyLoggerProxy(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        /*
        ClassLoader loader,
            被代理类的类加载器
        @NotNull Class<?>[] interfaces,
            被代理类实现的接口
        @NotNull reflect.InvocationHandler h
            代理的具体实现
         */
        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 基于接口的动态代理：jdk动态代理
                     * @param proxy 代理对象
                     * @param method 被代理的方法
                     * @param args 被代理方法的参数列表
                     * @return 被代理方法的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        beforeExecutingMethod(target.getClass().getSimpleName(), method.getName(), args);

                        Object ret = method.invoke(target, args);

                        //异常发生时的处理逻辑

                        afterExecutingMethod(target.getClass().getSimpleName(), method.getName(), ret);

                        return ret;
                    }
                });
        return proxyInstance;
    }

    public void beforeExecutingMethod(String clazzName, String methodName, Object[] args) {
        System.out.printf("执行方法 %s.%s 之前，方法参数为：%s\n", clazzName, methodName, Arrays.toString(args));
    }

    public void afterExecutingMethod(String clazzName, String methodName, Object object) {
        System.out.printf("执行方法 %s.%s 之后，返回值为：%s\n", clazzName, methodName, object.toString());
    }
}


