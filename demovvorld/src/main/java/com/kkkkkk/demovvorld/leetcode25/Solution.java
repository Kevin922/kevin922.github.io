package com.kkkkkk.demovvorld.leetcode25;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 看了看答案
     * 1. 递归。我大概猜到了递归 - 寻找子问题。我没想到具体做法。
     * 讲道理，这个兄弟将得棒。
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/di-gui-si-wei-ru-he-tiao-chu-xi-jie-by-labuladong/
     * 递归了"反转过程"。
     * 终结条件是已到null 或者 不足k个元素。
     * 这个思路简单易懂。
     * <p>
     * 2. 栈。先进后出。自然翻转。这个翻转听巧妙的。当然，递归也是栈的过程。这样理解也变得自然了。
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
