package com.kkkkkk.demovvorld;

public class Solution {
    int count = 0;

    public int numDecodings(String s) {
        // 递归穷举
        recur(s.substring(0, 1), s, 1);
        return count;

    }

    public void recur(String current, String s, int begin) {
        // terminate
        if (current.length() > 2 || current.startsWith("0")) {
            return;
        }
        Integer t = Integer.valueOf(current);
        if (t > 26 || t < 1) {
            return;
        }
        if (begin >= s.length()) {
            ++count;
            return;
        }
        // process
        // drill down
        recur(current + s.charAt(begin), s, begin + 1);
        recur(String.valueOf(s.charAt(begin)), s, begin + 1);
        // reset state
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("301"));
    }
}
