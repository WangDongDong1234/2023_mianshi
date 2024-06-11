package mianshi.chapter1.jdk;

import mianshi.chapter1.Calculator;
import mianshi.chapter1.CalculatorImpl;

public class JDKProxyTest {
    public static void main(String[] args) {
        MyLoggerProxy myLoggerProxy = new MyLoggerProxy(new CalculatorImpl());
        Calculator cal = (Calculator) myLoggerProxy.getProxy();

        cal.add(1, 2);
        System.out.println();
        cal.sub(4, 5);
    }

}
