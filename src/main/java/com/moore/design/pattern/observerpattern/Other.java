package com.moore.design.pattern.observerpattern;

import java.util.Observable;
import java.util.Observer;

/**
 * 其他订阅
 *
 * @author moore
 * @date 2020-01-11
 */
public class Other implements Observer {

    public Other(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        String data = ((Publish) o).getData();
        if ("1".equals(data)) {
            System.out.println("通知消息为 ：" + data + ", Other做出插入操作");
        } else if ("2".equals(data)) {
            System.out.println("通知消息为 ：" + data + ", Other做出修改操作");
        } else {
            System.out.println("通知消息为 ：" + data + ", Other做出删除操作");
        }
    }
}
