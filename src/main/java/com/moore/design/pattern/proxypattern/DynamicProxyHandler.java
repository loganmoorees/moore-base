package com.moore.design.pattern.proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 *
 * @author moore
 * @date 2020-01-09
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object object;

    public DynamicProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("帮你办理手续");
        Object obj = method.invoke(object, args);
        System.out.println("为你提供售后服务");
        return obj;
    }
}