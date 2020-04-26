package com.kkkkkk.demovvorld.leetcode15;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> targetMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            targetMap.put(nums[i], i);
        }

        List<List<Integer>> rst = new ArrayList<>(nums.length / 3);
        Set<String> unique = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int target = -(nums[i] + nums[j]);
                if (targetMap.get(target) != null
                        && targetMap.get(target) != i
                        && targetMap.get(target) != j) {
                    Integer[] r = new Integer[]{nums[i], nums[j], target};
                    Arrays.sort(r);
                    String uniqueStr = new StringBuilder().append(r[0]).append(",").append(r[1]).append(",").append(r[2]).toString();
//                    Integer uniqueInt = r[0] * 100 + r[1] * 10 + r[2];
                    if (!unique.contains(uniqueStr)) {
                        unique.add(uniqueStr);
                        rst.add(Arrays.asList(r));
                    }
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] t = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] t = new int[5000];
//        Arrays.fill(t, 0);

        System.out.println(JSON.toJSONString(new Solution().threeSum(t)));
    }
}
