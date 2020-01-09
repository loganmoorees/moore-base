package com.moore.design.pattern.proxypattern;

/**
 * 代理商
 *
 * @author moore
 * @date 2020-01-09
 */
public class Agent implements BuyCar {

    private Producers producers;

    public Agent(Producers producers) {
        this.producers = producers;
    }

    @Override
    public void buyCar() {
        System.out.println("帮你办理手续");
        producers.buyCar();
        System.out.println("为你提供售后服务");
    }
}
