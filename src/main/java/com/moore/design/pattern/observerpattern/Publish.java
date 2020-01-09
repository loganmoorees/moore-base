package com.moore.design.pattern.observerpattern;

import lombok.Data;

import java.util.Observable;

/**
 * 通知者
 *
 * @author moore
 * @date 2020-01-09
 */
public class Publish extends Observable {

    private String data = "";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (!this.data.equals(data)){
            this.data = data;
            setChanged();
        }
        notifyObservers();
    }

    public static void main(String[] args) {
        Publish publish = new Publish();
        Subscribe subscribe = new Subscribe(publish);
        publish.setData("aa");
    }
}
