package com.kkkkkk.demovvorld.LinkedList;

public class Node {
    Integer a = null;
    Node next = null;

    Node() {}

    Node(Integer a, Node next) {
        this.a = a;
        this.next = next;
    }

    public void print() {
        if (a == null) {
            return;
        }
        System.out.print(a);
        Node t = next;
        while (null != t) {
            System.out.print(" -> ");
            System.out.print(t.a);
            t = t.next;
        }
        System.out.println();
    }

    public static Node mockLinkedList() {
        Node n5 = new Node(5, null);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        return n1;
    }


}
