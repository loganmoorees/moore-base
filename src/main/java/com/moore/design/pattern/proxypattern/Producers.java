package com.moore.design.pattern.proxypattern;

/**
 * 生产商
 *
 * @author moore
 * @date 2020-01-09
 */
public class Producers implements BuyCar {

    @Override
    public void buyCar() {
        System.out.println("买了一辆车");
    }
}
