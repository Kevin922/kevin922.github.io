package com.kkkkkk.demovvorld.leetcode4;

import java.math.BigDecimal;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n > m) {
            int tmp = n;
            n = m;
            m = tmp;

            int[] tmpNums = nums1;
            nums1 = nums2;
            nums2 = tmpNums;
        }

        // 左1最大值、左2最大值、右1最小值、右2最小值、c1对nums1分割1、c2对nums2分割2、二分搜索最小值、二分搜索最大值
        int LMax1 = Integer.MIN_VALUE,
                LMax2 = Integer.MIN_VALUE,
                RMin1 = Integer.MAX_VALUE,
                RMin2 = Integer.MAX_VALUE,
                c1,
                c2,
                low = 0,
                high = 2 * n;

        /**
         * 两数组关系：n + m - c1
         * 二分搜索 较短的有序数组 效率更高。
         */
        while (low <= high) {
            c1 = (low + high) / 2;
            c2 = m + n - c1;

            LMax1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];
            LMax2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[(c2 - 1) / 2];
            RMin1 = (c1 >= 2 * n) ? Integer.MAX_VALUE : nums1[c1 / 2];
            RMin2 = (c2 >= 2 * m) ? Integer.MAX_VALUE : nums2[c2 / 2];

            if (LMax1 > RMin2) {
                high = c1 - 1;
            } else if (LMax2 > RMin1) {
                low = c1 + 1;
            } else {
                break;
            }
        }


        return new BigDecimal(Math.max(LMax1, LMax2) + Math.min(RMin1, RMin2))
                .divide(new BigDecimal(2), 4, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().findMedianSortedArrays(new int[]{2}, new int[]{}));
//        System.out.println(new Solution().findMedianSortedArrays(new int[]{2, 3}, new int[]{1}));
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
//        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}
