package com.kkkkkk.demovvorld.leetcode94;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        inorder(rst, root);
        return rst;
    }

    public void inorder(List<Integer> rst, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(rst, root.left);
        rst.add(root.val);
        inorder(rst, root.right);
    }
}