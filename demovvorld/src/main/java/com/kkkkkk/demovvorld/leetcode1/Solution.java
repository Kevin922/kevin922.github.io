package com.kkkkkk.demovvorld.leetcode1;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>(nums.length);
        for (Integer i = 0; i < nums.length; i++) {
            numIndexMap.put(nums[i], i);
        }
        for (Integer i = 0; i < nums.length; i++) {
            if (null != numIndexMap.get(target - nums[i]) && !numIndexMap.get(target - nums[i]).equals(i)) {
                Integer finalI = i;
                return new int[]{i, numIndexMap.get(target - nums[finalI])};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(
                new Solution().twoSum(
                        new int[]{3, 2, 4, 2},
                        6
                ))
        );
    }
}
