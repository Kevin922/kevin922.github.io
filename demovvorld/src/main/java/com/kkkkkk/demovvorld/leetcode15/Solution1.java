package com.kkkkkk.demovvorld.leetcode15;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 该方法存在错误
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        Map<Integer, int[]> targetMap = new HashMap<>();

        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int[] target = targetMap.get(nums[j]);
                if (target != null) {
                    List<Integer> t = Arrays.stream(targetMap.get(nums[j])).boxed().collect(Collectors.toList());
                    rst.add(t);
                    targetMap.put(nums[j], null);
                } else {
                    int[] t = new int[]{nums[i], nums[j], 0 - nums[i] - nums[j]};
                    targetMap.put((0 - nums[i] - nums[j]), t);
                }

            }
        }
        return rst;
    }

    public static void main(String[] args) {
//        int[] t = new int[]{-1, 0, 1, 2, -1, -4};
        int[] t = new int[]{1, 2, -2, -1};
//        int[] t = new int[5000];
//        Arrays.fill(t, 0);

        System.out.println(JSON.toJSONString(new Solution1().threeSum(t)));
    }
}
