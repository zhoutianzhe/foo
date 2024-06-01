package com.zrl.core.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author riliang.zrl
 * @Date 2024/5/18 11:11
 * @Description
 **/
public class PringInvocationHandler implements InvocationHandler {
    private Object target;

    public PringInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置处理");
        Object obj = method.invoke(target,args);
        System.out.println("后置处理");
        return obj;
    }
}
