/* Copyright (C) 2019-2019 Hangzhou HSH Co. Ltd.
 * All right reserved.*/
package com.moore.linear.structure;

import org.junit.Test;

/**
 * @author moore
 * @date 2019-09-23 16:57
 * @desc
 */
public class ListTest {

    private DoubleLinkedList<Object> doubleLinkedList = new DoubleLinkedList<>();

    @Test
    public void testSingleLinkedList() {
        doubleLinkedList.add(0);
        doubleLinkedList.add("hahha");
        doubleLinkedList.add(true);
        doubleLinkedList.showList();
        doubleLinkedList.add(2.57);
        doubleLinkedList.addIndex("新加的节点", 2);
        doubleLinkedList.showList();
        doubleLinkedList.remove(1);
        doubleLinkedList.showList();
    }

    @Test
    public void test() {
        String str = "f3bff6906e1747a3b5d2a52b17b18c51";
        System.out.println(str.length());
    }
}
