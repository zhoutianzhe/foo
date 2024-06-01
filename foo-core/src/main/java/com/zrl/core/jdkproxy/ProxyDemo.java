package com.zrl.core.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @Author riliang.zrl
 * @Date 2024/5/18 10:56
 * @Description
 **/
public class ProxyDemo {

    public static void main(String[] args) {
        UserService target = new UserServiceImpl();

        UserService userService = (UserService)  Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new PringInvocationHandler(target));

        userService.addUser("zrl");
    }

}
