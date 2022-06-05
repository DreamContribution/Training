package com.frank.training;

import java.util.Arrays;

public class No1475 {
    public static void main(String[] args) {
        No1475 no1475 = new No1475();
        int[] arr = {8, 4, 6, 2, 3};
        int[] ints = no1475.finalPrices(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int min = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    min = Math.min(min, prices[i] - prices[j]);
                    break;
                } else {
                    min = prices[i];
                }
            }
            result[i] = min;
        }

        return result;
    }
}
