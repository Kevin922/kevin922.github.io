package com.kkkkkk.demovvorld.LinkedList;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Reverse linkedList
 * Input:   1 -> 2 -> 3 -> 4 -> 5
 * Output:  5 -> 4 -> 3 -> 2 -> 1
 */
public class Reverse {
    private volatile int a = 1;
    public static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        Node head = Node.mockLinkedList();

        head.print();
        Reverse.reverse(head).print();
    }
}
