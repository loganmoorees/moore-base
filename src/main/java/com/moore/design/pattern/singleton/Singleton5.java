package com.moore.design.pattern.singleton;

/**
 * 静态内部类
 *
 * @author moore
 * @date 2020-01-08 15:25
 */
public class Singleton5 {

    /**
     * 内部类创建常量对象
     */
    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    /**
     * 私有构造器
     */
    private Singleton5() {
    }

    /**
     * 拿到常量对象返回
     *
     * @return
     */
    public static final Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
