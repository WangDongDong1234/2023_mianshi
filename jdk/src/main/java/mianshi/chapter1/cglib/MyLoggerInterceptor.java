package mianshi.chapter1.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyLoggerInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        beforeExecutingMethod(o.getClass().getSimpleName(), method.getName(), objects);

        // 注意这里是调用invokeSuper而不是invoke，否则死循环;
        // methodProxy.invokeSuper执行的是原始类的方法;
        // method.invoke执行的是子类的方法;
        Object ret = methodProxy.invokeSuper(o, objects);

        //异常发生时的处理逻辑

        afterExecutingMethod(o.getClass().getSimpleName(), method.getName(), ret);

        return ret;

    }

    public void beforeExecutingMethod(String clazzName, String methodName, Object[] objects) {
        System.out.printf("执行方法 %s.%s 之前，方法参数为：%s\n", clazzName, methodName, Arrays.toString(objects));
    }

    public void afterExecutingMethod(String clazzName, String methodName, Object object) {
        System.out.printf("执行方法 %s.%s 之后，返回值为：%s\n", clazzName, methodName, object.toString());
    }

}
