package com.frank.training;

public class No832 {

    public static void main(String[] args) {
        No832 no832 = new No832();
    }

    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] item : image) {
            reverse(item);
        }
        for (int[] item : image) {
            back(item);
        }
        return image;
    }

    public void reverse(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int temp;
        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public void back(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
    }
}
