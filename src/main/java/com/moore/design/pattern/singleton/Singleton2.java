package com.moore.design.pattern.singleton;

/**
 * 单例模式, 懒汉式，线程安全
 *
 * @author moore
 * @date 2020-01-08
 */
public class Singleton2 {

    /**
     * 提供静态对象
     */
    private static Singleton2 singleton;

    /**
     * 私有化构造器
     */
    private Singleton2() {
    }

    /**
     * 对外提供获取对象方法
     *
     * @return
     */
    public static synchronized Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
