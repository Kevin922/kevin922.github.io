package com.kkkkkk.demovvorld.leetcode26;

/**
 * 19年写过。20年不会。干得漂亮。
 * <p>
 * 跑不通，存个草稿了。
 * 跑不通的原因是因为我在debug中加入了nums[++i]的变量监视器 Orz
 * 导致每次i的值错误
 * <p>
 * 思路：
 * 快慢指针。
 * 慢指针指向已排序且无重复的最大下标。
 * 快指针寻找下一个不重复的元素。
 * <p>
 * 编程技巧：
 * 根据思路，可以想到快指针的时间复杂度是O(n)。
 * 一次循环中，慢指针i仅在`nums[i] != nums[i+1]`时，++i。
 * 快指针j始终++j.
 * <p>
 * `codeClean()`代码中：`nums[++i] = nums[j]`含义：在不使用O(n)的额外空间下，对有序数据剔除重复元素，同时还能nums[i]也代表了最后出现的数字。
 * <p>
 * 注意NO.26的题目要求：既要原地删除重复元素，又要返回无重复元素的数组长度。
 * `tinkingClear()`可以将`nums[++i] = nums[j]`替换为变了`int t`。
 * `int t`含义最后出现的无重复的数字。只要用`t`值，快指针j即可判断是否`nums[j]`是重复元素。
 **/
public class Solution {
    public int removeDuplicates(int[] nums) {
        thinkingClear(nums);
        return codeClean(nums);
    }

    private int thinkingClear(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = 0, t = nums[0];
        for (int j = 1; j < nums.length; ++j) {
            if (t != nums[j]) {
                t = nums[j];
                ++i;
            }
        }
        return i + 1;
    }

    private int codeClean(int[] nums) {
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
        new Solution().removeDuplicates(new int[]{1, 1, 2});
    }

}
