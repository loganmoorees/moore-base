
package com.moore.design.pattern.factorypattern;

/**
 * 具体实现
 *
 * @author moore
 * @date 2020-01-08
 */
public class Automobile implements CarParent {

    @Override
    public void buyCar() {
        System.out.println("买汽车");
    }
}
