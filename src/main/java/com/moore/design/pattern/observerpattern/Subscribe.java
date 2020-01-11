package com.moore.design.pattern.observerpattern;

import java.util.Observable;
import java.util.Observer;

/**
 * 消息订阅
 */
public class Subscribe implements Observer {

    public Subscribe(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        String data = ((Publish) o).getData();
        if ("1".equals(data)) {
            System.out.println("通知消息为 ：" + data + ", Subscribe做出插入操作");
        } else if ("2".equals(data)) {
            System.out.println("通知消息为 ：" + data + ", Subscribe做出修改操作");
        } else {
            System.out.println("通知消息为 ：" + data + ", Subscribe做出删除操作");
        }
    }
}
