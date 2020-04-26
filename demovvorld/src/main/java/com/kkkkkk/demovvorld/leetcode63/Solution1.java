package com.kkkkkk.demovvorld.leetcode63;

import java.util.Arrays;

public class Solution1 {
    /**
     * 最大行数
     */
    private int maxM;

    private int[] terminatorM;

    /**
     * 最大列数
     */
    private int maxN;

    private int[] terminatorN;

    private Integer[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return -1;
        }
        maxM = obstacleGrid.length;
        maxN = obstacleGrid[0].length;
        terminatorM = new int[maxN];
        Arrays.fill(terminatorM, 1);
        for (int i = maxN - 1; i >= 0; --i) {
            if (obstacleGrid[maxM - 1][i] == 1) {
                for (int j = i - 1; j >= 0; --j) {
                    terminatorM[j] = 0;
                }
                break;
            }
        }
        terminatorN = new int[obstacleGrid.length];
        Arrays.fill(terminatorN, 1);
        for (int p = maxM - 1; p >= 0; --p) {
            if (obstacleGrid[p][maxN - 1] == 1) {
                for (int q = p - 1; q >= 0; --q) {
                    terminatorN[q] = 0;
                }
                break;
            }
        }
        memo = new Integer[maxM][maxN];
        return divideConquer(0, 0, obstacleGrid);
    }

    private int divideConquer(int curM, int curN, int[][] obstacleGrid) {
        // terminator
        if (1 == obstacleGrid[curM][curN]) {
            return 0;
        }
        if (curM == maxM - 1) {
            return terminatorM[curN];
        }
        if (curN == maxN - 1) {
            return terminatorN[curM];
        }
        // process
        // drill down - divide & conquer
        if (memo[curM][curN] != null) {
            return memo[curM][curN];
        }
        memo[curM][curN] = divideConquer(curM + 1, curN, obstacleGrid) + divideConquer(curM, curN + 1, obstacleGrid);
        return memo[curM][curN];
        // reset state
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0,0,0},
                {0,0,0,0,1},
                {0,0,0,1,0},
                {0,0,1,0,0}
        };
        System.out.println(new Solution1().uniquePathsWithObstacles(obstacleGrid));
    }
}
