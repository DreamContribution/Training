package com.frank.data.sort;

import java.util.Arrays;

/**
 * 时间复杂度O(n^2)的冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {
        int temp = 0;//临时变量
        boolean flag = false;//标识变量，标识是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + i + "次排序后的数组");
            System.out.println(Arrays.toString(arr));
            if (!flag) {
                System.out.println("一次都没有发生过交换");
                break;
            } else {
                flag = false;//重置，用于下一轮判断
            }
        }
    }
}
