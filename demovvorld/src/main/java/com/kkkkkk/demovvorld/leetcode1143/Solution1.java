package com.kkkkkk.demovvorld.leetcode1143;

class Solution1 {
    public int longestCommonSubsequence(String text1, String text2) {
        char A[] = text1.toCharArray();
        char B[] = text2.toCharArray();
        int[] dp = new int[B.length + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[j + 1] = dp[j] + 1;
                }
            }
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {

                }
            }
            for (int j = 0; j < B.length; j++) {
                dp[j + 1] = Math.max(dp[j + 1], dp[j]);
            }
        }
        return dp[B.length];
    }
}
