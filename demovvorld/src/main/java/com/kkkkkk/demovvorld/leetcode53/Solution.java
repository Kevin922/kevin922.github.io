package com.kkkkkk.demovvorld.leetcode53;

import java.util.Arrays;

public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = nums;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i] + nums[i], nums[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
