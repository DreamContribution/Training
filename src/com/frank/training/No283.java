package com.frank.training;

import java.util.Arrays;

public class No283 {
    public static void main(String[] args) {
        No283 no283 = new No283();
        int[] arr = {0};
        no283.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0, temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                slow = i;
            }
            for (int j = slow; j < nums.length; j++) {
                if (nums[j] != 0) {
                    temp = nums[j];
                    nums[j] = nums[slow];
                    nums[slow] = temp;
                    slow++;
                }
            }
        }
    }

}
