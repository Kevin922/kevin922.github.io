package com.kkkkkk.demovvorld.leetcode589;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> rst = new ArrayList<>();
        preorderTraversal(rst, root);
        return rst;
    }

    private void preorderTraversal(List<Integer> rst, Node root) {
        if (root == null) {
            return;
        }
        rst.add(root.val);
        if (root.children != null && !root.children.isEmpty()) {
            for (Node child : root.children) {
                preorderTraversal(rst, child);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
