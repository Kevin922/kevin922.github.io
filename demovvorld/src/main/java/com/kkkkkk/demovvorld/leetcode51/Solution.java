package com.kkkkkk.demovvorld.leetcode51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private List<List<Integer>> rst = new ArrayList<>();

    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> xySubtract = new HashSet<>();
    private Set<Integer> xyPlus = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        solveNQueens(0, n, new ArrayList<>(n));
        drawChessBoard(rst);
        return null;
    }

    private List<List<String>> drawChessBoard(List<List<Integer>> rst) {
        return null;
    }

    /**
     * @param row             行
     * @param n               n * n
     * @param currentQueenCol 当前Queen所占Column
     */
    private void solveNQueens(int row, int n, List<Integer> currentQueenCol) {
        if (row == n) {
            rst.add(currentQueenCol);
        }
    }
}
