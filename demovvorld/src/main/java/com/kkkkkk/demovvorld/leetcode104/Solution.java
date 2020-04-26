package com.kkkkkk.demovvorld.leetcode104;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 1;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
