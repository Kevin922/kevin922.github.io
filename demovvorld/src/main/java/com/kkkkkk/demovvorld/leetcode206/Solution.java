package com.kkkkkk.demovvorld.leetcode206;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode t = cur;
            cur.next = pre;
            pre = cur;
            cur = t.next;
        }
        return pre;
    }
}
