package com.kkkkkk.demovvorld.leetcode2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class SolutionV2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, root = new ListNode(0);
        ListNode current = root;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int sum = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);

            current = current.next;
            p1 = (p1 != null ) ? p1.next : null;
            p2 = (p2 != null ) ? p2.next : null;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode r = new SolutionV2().addTwoNumbers(l11, l21);
        ListNode i = r;
        do {
            System.out.print(i.val);
            System.out.print("->");
        }
        while ((i = i.next) != null);
        System.out.println();
    }
}
