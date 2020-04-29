package com.kkkkkk.demovvorld;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BFS1 {
    static class Node {
        public String data;
        public Node left;
        public Node right;

        Node(String data) {
            this.data = data;
        }
    }

    public void traversal(Node start) {
        Deque<Node> queue = new LinkedList<>();
        queue.addFirst(start);
        List<Node> visted = new ArrayList<>();

        Node t = null;
        while ((t = queue.pollLast()) != null) {
            visted.add(t);
            // process(node);
            // generate related nodes
            if (t.left != null) {
                queue.addFirst(t.left);
            }
            if (t.right != null) {
                queue.addFirst(t.right);
            }
            //other processing work
        }

        for (Node e : visted) {
            System.out.print(e.data + " -> ");
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        new BFS1().traversal(n1);
    }
}
