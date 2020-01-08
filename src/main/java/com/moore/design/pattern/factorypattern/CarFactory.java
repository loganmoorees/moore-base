package com.moore.design.pattern.factorypattern;

/**
 * 汽车工厂类
 *
 * @author moore
 * @date 2020-01-08
 */
public class CarFactory {

    /**
     * 通过传入的参数动态的获取相关对象
     *
     * @param type
     * @return
     */
    public CarParent getCar(int type) {
        if (type == 0) {
            return new Automobile();
        } else if (type == 1) {
            return new SportsCar();
        } else {
            return new Vans();
        }
    }
}
