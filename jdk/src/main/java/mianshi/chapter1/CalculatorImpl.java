package mianshi.chapter1;

public class CalculatorImpl implements Calculator{
    @Override
    public int add(int a, int b) {
        System.out.println("执行方法 add");
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("执行方法 sub");
        return a - b;
    }
}
