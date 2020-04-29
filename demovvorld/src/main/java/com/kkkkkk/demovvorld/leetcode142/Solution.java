package com.kkkkkk.demovvorld.leetcode142;


public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode getIntersect(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        ListNode a = head;
        ListNode c = intersect;
        while (a != c) {
            a = a.next;
            c = c.next;
        }
        return a;
    }
}