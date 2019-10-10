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

    @Test
    public void testSingleLinkedList() {
        singleLinkedList.add(0);
        singleLinkedList.add("hahha");
        singleLinkedList.add(true);
        singleLinkedList.add(2.57);
        singleLinkedList.showList();
        singleLinkedList.addIndex("新加的节点", 2);
        singleLinkedList.showList();
    }

    @Test
    public void test() {
        String str = "f3bff6906e1747a3b5d2a52b17b18c51";
        System.out.println(str.length());
    }
}
