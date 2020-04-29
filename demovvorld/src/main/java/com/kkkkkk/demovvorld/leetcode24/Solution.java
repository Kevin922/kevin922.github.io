package com.kkkkkk.demovvorld.leetcode24;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            pre.next = second;
            first.next = second.next;
            second.next = first;

            pre = first;
            head = first.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = null;

        new Solution().swapPairs(ln1);
    }
}
