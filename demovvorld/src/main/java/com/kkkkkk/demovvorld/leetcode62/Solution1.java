package com.kkkkkk.demovvorld.leetcode62;

public class Solution1 {
    public int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m][n];
        for (int i = 0; i < n; ++i) {
            memo[m - 1][i] = 1;
        }
        for (int j = 0; j < m; ++j) {
            memo[j][n - 1] = 1;
        }
        return divideConquer(0, 0, m, n, memo);
    }

    private int divideConquer(int curM, int curN, int m, int n, Integer[][] memo) {
        // terminator
        if (memo[curM][curN] != null) {
            return memo[curM][curN];
        }
        // divide & conquer
        memo[curM][curN] =
                divideConquer(curM + 1, curN, m, n, memo) + divideConquer(curM, curN + 1, m, n, memo);
        return memo[curM][curN];
        // reset state
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().uniquePaths(3, 2));
    }
}
