package com.frank.data.search;

import java.util.Arrays;

public class FibonacciSearch {
    public static final int MAX_SIZE = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
    }

    //获取斐波那契数列
    public static int[] fib() {
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 0; i < MAX_SIZE; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契查找算法
     *
     * @param a   目标数组
     * @param key 关键码
     * @return 目标索引
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;// 斐波那契分割点
        int mid = 0;
        int[] f = fib();
        while (high > f[k] - 1) {
            k++;
        }
        //因为F[k]值可能大于a的长度，因此需要补充长度
        //不足部分使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        //实际需要使用a数组最后的值进行填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                // 左半部查找
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                //需要确定返回哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
