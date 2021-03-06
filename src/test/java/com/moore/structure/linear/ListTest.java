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
        sort.singlePivotQuickSort(nums, 0, nums.length - 1);
        int result = sort.binarySearch(nums, 1, 0, nums.length - 1);
        System.out.println("二分查找结果索引: " + result);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
