package com.kkkkkk.demovvorld.leetcode433;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
    }

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        char[] four = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.remove(start);
        int step = 0;
        while (queue.size() > 0) {
            step++;
            for (int count = queue.size(); count > 0; --count) {
                char[] temStringChars = queue.poll().toCharArray();
                for (int i = 0, len = temStringChars.length; i < len; ++i) {
                    char oldChar = temStringChars[i];
                    for (int j = 0; j < 4; ++j) {
                        temStringChars[i] = four[j];
                        String newGenetic = new String(temStringChars);
                        if (end.equals(newGenetic)) {
                            return step;
                        } else if (set.contains(newGenetic)) {
                            set.remove(newGenetic);
                            queue.offer(newGenetic);
                        }
                    }
                    temStringChars[i] = oldChar;
                }
            }
        }
        return -1;
    }
}

