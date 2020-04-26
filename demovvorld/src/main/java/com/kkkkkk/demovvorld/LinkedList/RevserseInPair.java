package com.kkkkkk.demovvorld.LinkedList;

/**
 * 互联网最大的魅力不是连接人与人，而是人与人都被吸附到了这个『网』上。
 *
 * 所有LinkedList翻转 题目都可以尝试虚拟一个null为head。这方便思考。
 * 如果需要一个原因，可以理解：尾部node的next指向null。既然翻转了，null也就变为了head。
 *
 *
 * Reverse linkedList in pair
 * Input:   1 -> 2 -> 3 -> 4 -> 5
 * Output:  2 -> 1 -> 4 -> 3 -> 5
 */
public class RevserseInPair {

    /**
     * @param head
     * @return linkdedList head
     */
    public static Node reverseInPair(Node head) {
        Node pre = new Node();
        pre.next = head;
        head = pre;
        while (pre.next != null && pre.next.next != null) {
            Node temp3 = pre.next.next.next;
            pre.next.next.next = pre.next;
            Node temp1 = pre.next;
            pre.next = pre.next.next;
            temp1.next = temp3;
            pre = temp1;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node head = Node.mockLinkedList();

        head.print();
        RevserseInPair.reverseInPair(head).print();
    }
}
