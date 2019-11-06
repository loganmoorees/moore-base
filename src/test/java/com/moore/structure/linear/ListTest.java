package com.moore.structure.linear;

import com.moore.sort.Sort;
import org.junit.Test;

/**
 * @author moore
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
        Sort sort = new Sort();
//        125, 4, 54, 13, 47, 65, 66, 21, 42, 48, 62, 1, 1
        int[] nums = {2, 5, 1, 4, 3};
        int[] ints = sort.dualPivotQuickSort(nums, 0, nums.length - 1);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
