package com.moore.design.pattern.singleton;

/**
 * 单例模式, 懒汉式，线程不安全
 *
 * @author moore
 * @date 2020-01-08
 */
public class Singleton1 {

    /**
     * 提供静态对象
     */
    private static Singleton1 singleton;

    /**
     * 私有化构造器
     */
    private Singleton1() {
    }

    /**
     * 对外提供获取对象方法
     *
     * @return
     */
    public static Singleton1 getInstance() {
        if (singleton == null) {
            singleton = new Singleton1();
        }
        return singleton;
    }
}
