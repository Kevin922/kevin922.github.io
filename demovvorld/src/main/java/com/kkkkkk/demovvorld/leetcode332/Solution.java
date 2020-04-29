package com.kkkkkk.demovvorld.leetcode332;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        final int MAX = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        new Solution().coinChange(new int[]{1, 2, 5}, 11);
    }
}
