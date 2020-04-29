package com.kkkkkk.demovvorld.leetcode5;

public class Solution {
    public String longestPalindrome(String s) {
        String ss = pre(s);
        int[] rl = new int[ss.length()];
        int pos = 0, maxRight = 0, maxLen = 0, maxLenIndex = 0;
        for (int i = 0; i < ss.length(); ++i) {
            if (i < maxRight) {
                rl[i] = Math.min(rl[pos * 2 - i], maxRight - i);
            } else {
                rl[i] = 1;
            }
            while ((i - rl[i] >= 0) && (i + rl[i] < ss.length()) && (ss.charAt(i - rl[i]) == ss.charAt(i + rl[i]))) {
                rl[i] += 1;
            }
            if (i + rl[i] > maxRight) {
                maxRight = i + rl[i] - 1;
                pos = i;
                if (maxLen < rl[i]) {
                    maxLen = rl[i];
                    maxLenIndex = i;
                }
            }
        }

        return after(ss.substring(maxLenIndex - rl[maxLenIndex] + 1, maxLenIndex + rl[maxLenIndex]));
    }


    private String pre(String s) {
        String r = "#";
        for (int i = 0; i < s.length(); ++i) {
            r = r + s.charAt(i) + "#";
        }
        return r;
    }

    private String after(String ss) {
        String r = "";
        for (int i = 1; i < ss.length(); i += 2) {
            r = r + ss.charAt(i);
        }
        return r;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().longestPalindrome("babad"));
//        System.out.println(new Solution().longestPalindrome("cbbd"));
//        System.out.println(new Solution().longestPalindrome("c"));
        System.out.println(new Solution().longestPalindrome(""));
    }
}
