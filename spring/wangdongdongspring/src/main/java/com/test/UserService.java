package com.test;

import com.core.Autowired;
import com.core.Component;
import com.core.InitializingBean;
import com.core.Scope;

@Component("userService")
@Scope("prototype")
public class UserService  implements InitializingBean {  // BeanDefinition---->Map<'beanName',BeanDefinition对象>

    @Autowired
    private OrderService orderService;

    public User defaultUser;

    public void test(){
        System.out.println("依赖注入："+orderService);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultUser = new User();
    }
}
