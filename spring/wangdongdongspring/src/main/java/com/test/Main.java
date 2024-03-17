package com.test;

import com.core.WangDongDongApplicationContext;

public class Main {
    public static void main(String[] args) {
        WangDongDongApplicationContext context = new WangDongDongApplicationContext(AppConfig.class);

        UserService userService = (UserService) context.getBean("userService");
        userService.test();
        System.out.println("InitializingBean:"+userService.defaultUser);

        System.out.println(userService);

        UserService userService2 = (UserService) context.getBean("userService");

        System.out.println(userService2);
    }
}
