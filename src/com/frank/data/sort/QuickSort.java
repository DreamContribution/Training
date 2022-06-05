package com.frank.data.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp;//用于交换
        while (l < r) {
            // 左侧找到某个大于中间值的值
            while (arr[l] < pivot) {
                l += 1;
            }
            // 右侧找到某个小于
            while (arr[r] > pivot) {
                r -= 1;
            }
            // 说明左侧已经小于pivot，右侧大于等于pivot
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //交换完成后，若arr[l] == pivot 相等，前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //交换完成后，若arr[r] == pivot 相等，后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果l == r,必须l++，r--，否则出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }


        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }

    }
}
