package juc;

import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // 添加元素
        map.put("one", 1);
        map.put("two", 2);

        // 并发地更新元素
        map.computeIfPresent("one", (k, v) -> v + 10);

        // 并发地删除元素
        map.remove("two", 2);

        // 遍历ConcurrentHashMap
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
