package com.kkkkkk.demovvorld;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public String[] checkSerialNumber(int[] nums) {
        // 暴力
        if (nums.length == 0) {
            return new String[]{};
        }
        if (nums.length == 1) {
            return new String[]{nums[0] + ""};
        }
        // 我总觉得，倒序遍历这个数据，会有奇效。。。
        // 算了，正序遍历，如果是连续的，指针就+1；如果不连续，指针就向后
        List<String> rst = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            for (int j = i + 1; j < nums.length; ++j) {
                // 遍历结束
                if (j == nums.length - 1) {
                    rst.add(nums[i] + "-" + nums[j]);
                    i = nums.length;
                    break;
                }
                // 连续，++j
                if (nums[j - 1] + 1 == nums[j]) {
                    continue;
                }
                // 不连续，判断j-i是否等于1
                if (j - i == 1) {
                    // 等于1，结果保存一个元素
                    rst.add(String.valueOf(nums[i]));
                } else {
                    // 不等于1，结果保存区间；i = j
                    rst.add(nums[i] + "-" + nums[j - 1]);
                    i = j;
                    break;
                }

            }
        }
        return rst.toArray(new String[]{});
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 7, 8, 9};
        System.out.println(new Test3().checkSerialNumber(nums));
    }
}
