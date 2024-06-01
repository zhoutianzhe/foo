package com.zrl.core.jdkproxy;

/**
 * @Author riliang.zrl
 * @Date 2024/5/18 10:55
 * @Description
 **/
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(String name){
        System.out.println("新增user："+name);
    }

}
