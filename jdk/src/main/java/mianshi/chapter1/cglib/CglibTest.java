package mianshi.chapter1.cglib;

import mianshi.chapter1.CalculatorImpl;
import net.sf.cglib.proxy.Enhancer;

public class CglibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(CalculatorImpl.class);
        //设置回调函数
        enhancer.setCallback(new MyLoggerInterceptor());
        //创建代理类
        CalculatorImpl calculatorImpl = (CalculatorImpl) enhancer.create();

        //调用代理类的业务方法
        calculatorImpl.add(1, 2);
        System.out.println();
        calculatorImpl.sub(4, 5);

    }
}
