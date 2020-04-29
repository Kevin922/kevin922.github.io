package com.kkkkkk.demovvorld;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DequeExample {
    public static void main(String[] args) {
        System.out.println("双端队列");
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String peekElement = deque.peekFirst();
        System.out.println(peekElement);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);

        System.out.println();
        System.out.println("栈");
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack);
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

        System.out.println();
        System.out.println("队列");
        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        System.out.println(queue);
        while (queue.size() > 0) {
            System.out.println(queue.remove());
        }
    }
}
