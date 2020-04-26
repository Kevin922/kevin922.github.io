package com.kkkkkk.demovvorld.leetcode62;

public class Solution {
    public int uniquePaths(int m, int n) {
        return divideConquer(0, 0, m, n);
    }

    private int divideConquer(int curM, int curN, int m, int n) {
        // terminator
        if (curM == m - 1 || curN == n - 1) {
            return 1;
        }
        // divide & conquer
        return divideConquer(curM + 1, curN, m, n) + divideConquer(curM, curN + 1, m, n);
        // reset state
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 2));
    }
}
