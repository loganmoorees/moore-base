package com.moore.sort;

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
     * 双轴快速排序
     * <p>
     * 理解：
     *
     * @param
     * @return
     */
    public int[] dualPivotQuickSort(int[] nums, int start, int end) {
        int i, j, pivot, temp;
        if (start >= end) return nums;
        i = start;
        j = end;
        pivot = nums[start];

        while (i < j) {
            while (nums[j] >= pivot && i < j) {
                j--;
            }

            while (nums[i] <= pivot && i < j) {
                i++;
            }
            if (i < j) {
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        nums[start] = nums[i];
        nums[i] = pivot;
        dualPivotQuickSort(nums, start, j - 1);
        dualPivotQuickSort(nums, j + 1, end);
        return nums;
    }
}