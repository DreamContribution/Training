package com.frank.training;

import java.util.Arrays;

public class No26 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        No26 target = new No26();
        int i = target.removeDuplicates(nums);
        System.out.println("result:" + i);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
                nums[i] = Integer.MAX_VALUE;
            }
        }

        Arrays.sort(nums);

        return count;
    }
}
