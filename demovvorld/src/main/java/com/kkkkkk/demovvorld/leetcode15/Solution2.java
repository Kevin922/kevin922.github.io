package com.kkkkkk.demovvorld.leetcode15;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        Set<Integer> processed = new HashSet<>();
        Map<Integer, Boolean> targetUsedMap = new HashMap<>();

        for (int i = 0; i < nums.length - 1; ++i) {
            if (processed.contains(nums[i])) {
                continue;
            }
            targetUsedMap.clear();
            for (int j = i + 1; j < nums.length; ++j) {
                Integer target = -(nums[i] + nums[j]);
                if (!targetUsedMap.containsKey(target)) {
                    if (!targetUsedMap.containsKey(nums[j])) {
                        targetUsedMap.put(nums[j], false);
                    }
                } else if (!targetUsedMap.get(target) && !processed.contains(nums[j]) && !processed.contains(target)) {
                    rst.add(Arrays.asList(nums[i], nums[j], target));
                    targetUsedMap.put(target, true);
                }
            }

            processed.add(nums[i]);
        }
        return rst;
    }

    public static void main(String[] args) {
//        int[] t = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] t = new int[]{1, 1, -2, 1, 1, -2, -2, 1, 1};
//        int[] t = new int[]{1, 2, -2, -1};
        int[] t = new int[5000];
        Arrays.fill(t, 0);

        System.out.println(JSON.toJSONString(new Solution2().threeSum(t)));
    }
}
