/* Copyright (C) 2019-2019 Hangzhou HSH Co. Ltd.
 * All right reserved.*/

import com.moore.linear.structure.SingleLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author moore
 * @date 2019-09-16 15:53
 * @desc 测试
 */
public class Test {

    LinkedList linkedList = new LinkedList();
    ArrayList arrayList = new ArrayList();
    SingleLinkedList singleLinkedList = new SingleLinkedList();

    @org.junit.Test
    public void testSingleLinkedList() {
        singleLinkedList.add(0);
        singleLinkedList.add("hahha");
        singleLinkedList.add(true);
        singleLinkedList.add(2.57);
        System.out.println(singleLinkedList.length());
        System.out.println(singleLinkedList.get(0));
        Object o = singleLinkedList.remove(0);
        System.out.println(o);
        System.out.println(singleLinkedList.get(0));

        System.out.println("----------");
        System.out.println(singleLinkedList.length());
    }
}
