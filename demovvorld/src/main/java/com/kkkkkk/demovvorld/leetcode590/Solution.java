package com.kkkkkk.demovvorld.leetcode590;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> rst = new ArrayList<>();
        postorderTraversal(rst, root);
        return rst;
    }

    private void postorderTraversal(List<Integer> rst, Node root) {
        if (root == null) {
            return;
        }
        if (root.children != null && !root.children.isEmpty()) {
            for (Node child : root.children) {
                postorderTraversal(rst, child);
            }
        }
        rst.add(root.val);
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
