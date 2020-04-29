package com.kkkkkk.demovvorld.leetcode429;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // 恰好，队列中的节点，都是兄弟节点
            int brotherSize = queue.size();
            for (int i = 0; i < brotherSize; ++i) {
                Node brother = queue.remove();
                level.add(brother.val);
                for (Node child : brother.children) {
                    queue.add(child);
                }
            }
            rst.add(level);
        }
        return rst;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
