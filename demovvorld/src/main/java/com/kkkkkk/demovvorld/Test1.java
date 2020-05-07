package com.kkkkkk.demovvorld;


import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        Map<String, String> hello = new HashMap<>();
        hello.put("a1", "11");
        hello.put("a2", "22");
        hello.put("a3", "33");
        System.out.println(hello);
    }

    public void test(int i, int max) {
        // terminate
        if (i >= max) {
            return;
        }

        // process

        // drill down
        test(i + 1, max);


        // reverse state
    }
}


