/* Copyright (C) 2019-2019 Hangzhou HSH Co. Ltd.
 * All right reserved.*/
package com.moore.linear.structure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author moore
 * @date 2019-09-23 16:57
 * @desc
 */
public class ListTest {

    LinkedList linkedList = new LinkedList();
    ArrayList arrayList = new ArrayList();
    SingleLinkedList singleLinkedList = new SingleLinkedList();
    DoubleLinkedlist doubleLinkedlist = new DoubleLinkedlist();

    @Test
    public void testSingleLinkedList() {
        doubleLinkedlist.add(0);
        doubleLinkedlist.add("hahha");
        doubleLinkedlist.add(true);
        doubleLinkedlist.showList();
        doubleLinkedlist.add(2.57);
        doubleLinkedlist.addIndex("新加的节点", 2);
        doubleLinkedlist.showList();
    }

    @Test
    public void test() {
        String str = "f3bff6906e1747a3b5d2a52b17b18c51";
        System.out.println(str.length());
    }
}
