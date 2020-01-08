package com.moore.design.pattern.singleton;

/**
 * 单例模式, 饿汉式，线程安全
 *
 * @author moore
 * @date 2020-01-08
 */
public class Singleton3 {

    /**
     * 构造私有静态对象
     */
    private static Singleton3 singleton = new Singleton3();

    /**
     * 私有化构造器
     */
    private Singleton3() {
    }

    /**
     * 返回对象
     *
     * @return
     */
    public static Singleton3 getInstance() {
        return singleton;
    }
}
