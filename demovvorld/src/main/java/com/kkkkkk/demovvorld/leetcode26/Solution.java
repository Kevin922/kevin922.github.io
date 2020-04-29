package com.kkkkkk.demovvorld.leetcode26;

/**
 * 19年写过。20年不会。干得漂亮。
 * 跑不通，存个草稿了。
 **/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        new Solution().removeDuplicates(new int[]{1, 2, 3, 3, 4, 4, 5});
    }

}
