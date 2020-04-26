package com.kkkkkk.demovvorld.leetcode2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i1 = new ListNode(0);
        ListNode root = i1;

        ListNode x = l1;
        ListNode y = l2;
        int carry = 0;

        while (true) {
            int tVal = (x == null ? 0 : x.val) + (y == null ? 0 : y.val) + carry;
            carry = tVal >= 10 ? 1 : 0;
            i1.val = tVal % 10;

            ListNode i2 = (carry == 1) ? new ListNode(1) : new ListNode(0);

            x = (x == null ? x : x.next);
            y = (y == null ? y : y.next);

            if (x == null && y == null) {
                i1.next = i2.val == 0 ? null : i2;
                break;
            } else {
                i1.next = i2;
                i1 = i2;
            }
        }

        return root;
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

        ListNode r = new Solution().addTwoNumbers(l11, l21);
        ListNode i = r;
        do {
            System.out.print(i.val);
            System.out.print("->");
        }
        while ((i = i.next) != null);
        System.out.println();
    }
}
