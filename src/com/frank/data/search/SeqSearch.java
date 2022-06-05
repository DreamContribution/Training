package com.frank.data.search;

public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = seqSearch(arr, 11);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.printf("Got it,下标为=%d", index);
        }

    }

    /**
     * 仅查找一个就返回
     *
     * @param arr   目标数组
     * @param value 查询的值
     * @return 返回索引
     */
    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
