package com.kkkkkk.demovvorld.leetcode70;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> nWayMap = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        if (!nWayMap.containsKey(n)) {
            nWayMap.put(n, climbStairs(n-1) + climbStairs(n-2));
        }
        return nWayMap.get(n);
    }
}
