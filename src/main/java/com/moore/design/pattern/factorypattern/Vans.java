package com.moore.design.pattern.factorypattern;

/**
 * 具体实现
 *
 * @author moore
 * @date 2020/1/8 17:19
 */
public class Vans implements CarParent {

    @Override
    public void buyCar() {
        System.out.println("买货车");
    }
}
