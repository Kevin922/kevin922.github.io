package com.kkkkkk.demovvorld.leetcode22;

public class SimpleGenerateParentesis {
    public static void main(String[] args) {
        generateParentesis(3);
    }

    private static void generateParentesis(int k) {
        generateParentesisRecursive(0, k * 2, "");
    }

    private static void generateParentesisRecursive(int i, int max, String s) {
        // terminate
        if (i >= max) {
            System.out.println(s);
            return;
        }

        // process

        // drill down
        generateParentesisRecursive(i + 1, max, s + "(");
        generateParentesisRecursive(i + 1, max, s + ")");

        // clean up

    }
}
