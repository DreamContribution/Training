package com.frank.data.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 该搜索必须数组有序
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int i = binarySearch(arr, 0, arr.length, -10);
        System.out.println("result:" + i);


        int[] arr1 = {1, 8, 10, 89, 1234};
        List<Integer> integers = binarySearch2(arr1, 0, arr1.length, 1000);
        System.out.println("result:" + integers);
    }

    /**
     * 二分查找
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        //当left > right, 说明没有，需要返回
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        //当left > right, 说明没有，需要返回
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            /*
             * 不立刻直接返回mid，而是左右继续移动，将所有符合条件的值放入集合中
             * */
            List<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }

            resIndexList.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }

            return resIndexList;
        }
    }


}
