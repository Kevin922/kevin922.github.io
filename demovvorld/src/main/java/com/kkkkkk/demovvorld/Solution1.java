package com.kkkkkk.demovvorld;

public class Solution1 {
    public int numDecodings(String s) {

        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        dp[s.length() - 1] = s.charAt(s.length() - 1) != '0' ? 1 : 0;

        for (int i = s.length() - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else dp[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? dp[i + 1] + dp[i + 2] : dp[i + 1];

        return dp[0];
    }
}
