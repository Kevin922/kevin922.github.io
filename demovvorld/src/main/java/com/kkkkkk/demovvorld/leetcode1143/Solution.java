package com.kkkkkk.demovvorld.leetcode1143;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int p = 1; p < text2.length(); p++) dp[0][p] = text1.charAt(0) == text2.charAt(p) ? 1 : dp[0][p - 1];
        for (int q = 1; q < text1.length(); q++) dp[q][0] = text2.charAt(0) == text1.charAt(q) ? 1 : dp[q - 1][0];
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int[] row : dp) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + ",");
            }
            System.out.println();
        }

        return dp[text1.length() - 1][text2.length() - 1];
    }

    public static void main(String[] args) {
        String text1 = "adb";
        String text2 = "def";
        new Solution().longestCommonSubsequence(text1, text2);
    }
}
