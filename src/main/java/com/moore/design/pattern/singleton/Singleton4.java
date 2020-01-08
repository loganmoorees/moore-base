package com.moore.design.pattern.singleton;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 *
 * @author moore
 * @date 2020-01-08 15:20
 */
public class Singleton4 {

    /**
     * 构造静态对象
     */
    private volatile static Singleton4 singleton;

    /**
     * 私有化构造器
     */
    private Singleton4() {
    }

    /**
     * 懒汉式双重校验
     *
     * @return
     */
    public static Singleton4 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton4.class) {
                if (singleton == null) {
                    singleton = new Singleton4();
                }
            }
        }
        return singleton;
    }
}
