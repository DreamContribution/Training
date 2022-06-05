package com.frank.data.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //左递归,分解
            mergeSort(arr, left, mid, temp);
            //右递归，分解
            mergeSort(arr, mid + 1, right, temp);

            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 归并排序(合并)
     *
     * @param arr   待排序数组
     * @param left  左索引
     * @param mid   中间索引
     * @param right 右索引，注意：是最后的索引，非长度，即arr.length-1
     * @param temp  中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左初始化索引
        int j = mid + 1;// 右初始化索引
        int t = 0;// temp数组的当前索引

        // 1.左右比较，一直到某边的数据全部进入temp
        while (i <= mid && j <= right) {
            //左边的小于右边的，放入左边数据，左、temp指针移动
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        // 2.把另一半的剩余数据按顺序放入temp
        while (i <= mid) {
            //左边有剩余，全部填入
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= right) {
            //右边有剩余，全部拷入
            temp[t] = arr[j];
            t++;
            j++;
        }

        // 3.temp拷贝进arr
        t = 0;
        int temLeft = left;
        while (temLeft <= right) {
            arr[temLeft] = temp[t];
            t++;
            temLeft += 1;
        }
    }
}
