package com.kkkkkk.demovvorld.leetcode189;

import com.alibaba.fastjson.JSON;

public class Solution1 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        int[] t = new int[]{1, 2, 3, 4, 5};
        new Solution1().rotate(t, 2);
        System.out.println(JSON.toJSONString(t));
    }
}
