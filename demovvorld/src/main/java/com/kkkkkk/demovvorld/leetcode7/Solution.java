package com.kkkkkk.demovvorld.leetcode7;

public class Solution {
    public int reverse(int x) {
        int tmp = 0;

        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (tmp > Integer.MAX_VALUE / 10 || (tmp == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            } else if (tmp < Integer.MIN_VALUE / 10 || (tmp == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            } else {
                tmp = tmp * 10 + pop;
            }
        }

        return tmp;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().reverse(100));
//        System.out.println(new Solution().reverse(922));
//        System.out.println(new Solution().reverse(210));
//        System.out.println(new Solution().reverse(85017845));
//        System.out.println(new Solution().reverse(1999999999));
        System.out.println(new Solution().reverse(-123));
    }
}

/**
 *
 * 3

 pioneer先锋             2012.01-2013.01
 - 成都乐动信息             2013.01-2014.03

 农丰时代科技有限公司      2014.04-2016.01
 成都数联铭品科技有限公司  2016.01-2017.10

 - 四川驹马                2017.10-2018.08
 大农科技               ~2019.07


 */
