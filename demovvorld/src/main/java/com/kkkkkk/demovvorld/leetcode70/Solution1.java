package com.kkkkkk.demovvorld.leetcode70;

public class Solution1 {
    // 暴力法
    // 递推公式：想象下n阶楼梯的方法：f(n) = f(n-1) + f(n-2)
    // 上楼梯的方法 和 下楼梯的方法 相同
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

}
