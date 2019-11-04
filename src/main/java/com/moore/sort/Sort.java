package com.moore.sort;

import java.util.Arrays;

public class Sort {

    /**
     * 冒泡排序
     * <p>
     * 理解： 冒泡排序核心思想就是两两相比
     * 外层的for循环控制着循环次数，n个数字两两相比n-1次
     * 内层的for循环控制着每一次选出最大的数放在最后：
     * 第一次选出最大数后，需要比较n-1次
     * 第二次比较，则比较n-2次，最后一次只需要比较一次
     *
     * @param nums
     * @return
     */
    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 快速排序
     * <p>
     * 理解：
     *
     * @param nums
     * @return
     */
    public int[] quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int start = 0;
        int end = nums.length;
        int base = nums[start];
        return nums;
    }
}