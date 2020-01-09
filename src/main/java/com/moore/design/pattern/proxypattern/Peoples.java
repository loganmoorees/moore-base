package com.moore.design.pattern.proxypattern;

import java.lang.reflect.Proxy;

/**
 * 买了一辆车，生产商只负责汽车生产，由代理商提供各种面向客户的服务
 *
 * @author moore
 * @date 2020-01-09
 */
public class Peoples {

    /**
     * 静态代理
     */
    public static void buyCar() {
        Producers producers = new Producers();
        Agent agent = new Agent(producers);
        agent.buyCar();
    }

    /**
     * 动态代理
     */
    public static void dynamicBuyCar() {
        BuyCar producers = new Producers();
        BuyCar agent = (BuyCar) Proxy.newProxyInstance(BuyCar.class.getClassLoader(),
                new Class[]{BuyCar.class}, new DynamicProxyHandler(producers));
        agent.buyCar();
    }

    public static void main(String[] args) {
        dynamicBuyCar();
    }
}
