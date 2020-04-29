package com.kkkkkk.demovvorld.leetcode144;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        preorder(rst, root);
        return rst;
    }

    public void preorder(List<Integer> rst, TreeNode root) {
        if (root == null) {
            return;
        }
        rst.add(root.val);
        preorder(rst, root.left);
        preorder(rst, root.right);
    }
}