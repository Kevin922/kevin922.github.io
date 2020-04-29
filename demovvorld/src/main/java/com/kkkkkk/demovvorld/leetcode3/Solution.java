package com.kkkkkk.demovvorld.leetcode3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int i = 0, j = 1;
        int maxLength = 1;
        Map<Character, Integer> slide = new HashMap<>();
        slide.put(s.charAt(i), i);
        while ((j < s.length()) && (i < j)) {
            if (slide.get(s.charAt(j)) != null && slide.get(s.charAt(j)).compareTo(i) >= 0) {
                i = slide.get(s.charAt(j)) + 1;
            } else {
                maxLength = ((j - i + 1) > maxLength) ? (j - i + 1) : maxLength;
            }
            slide.put(s.charAt(j), j);
            ++j;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("au"));
    }
}
