package com.kkkkkk.demovvorld.leetcode1;

import java.util.HashMap;
import java.util.Map;

public class RedoOne {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndex = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int pairNum = target - nums[i];
            if (numIndex.containsKey(pairNum)) {
                return new int[]{i, numIndex.get(pairNum)};
            } else {
                numIndex.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
