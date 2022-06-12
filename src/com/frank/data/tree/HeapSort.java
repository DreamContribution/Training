package com.frank.data.tree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {
        System.out.println("堆排序！！！");
        //分布完成
        //adjustHeap(arr, 1, arr.length);
        //System.out.println("第一次：" + Arrays.toString(arr));
        //
        //adjustHeap(arr, 0, arr.length);
        //System.out.println("第二次：" + Arrays.toString(arr));

        //完成最终代码
        //先构建成大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        /**
         * 2.最大元素放队尾
         * 3.重复
         */
        int temp;
        for (int i = arr.length - 1; i > 0; i--) {
            //交换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
        System.out.println("结果：" + Arrays.toString(arr));
    }

    /**
     * 将一个数组（二叉树）调整成一个大顶堆
     * <p>
     * 功能：完成将以i对应的非叶子节点的树调整成大顶堆
     *
     * @param arr    待排序的数组
     * @param i      非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整，length是在逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整
        //注意：i的左子节点开始
        for (int k = i * 2 + 1; k < length; k = i * 2 + 1) {
            if ((k + 1) < length && arr[k] < arr[k + 1]) {
                //左子节点的值小于右子节点的值
                k++;//k指向右子节点
            }
            if (arr[k] > temp) {
                // 子节点 > 父节点
                arr[i] = arr[k];//交换树内值
                i = k;//让i指向k，继续循环
            } else {
                break;
            }
        }
        //当for循环结束后，已经将以i为父节点的树的最大值，放在了最顶
        arr[i] = temp;//将temp值放到了调整后的位置
    }
}
