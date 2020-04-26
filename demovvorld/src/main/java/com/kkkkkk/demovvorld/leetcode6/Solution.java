package com.kkkkkk.demovvorld.leetcode6;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        Character[][] rst = new Character[numRows][s.length()];

        int row = 0, column = 0;
        int rp = 0, cp = 0;
        for (int i = 0; i < s.length(); ++i) {
            rst[row += rp][column += cp] = s.charAt(i);
            if (row == 0) {
                rp = 1;
                cp = 0;
            }
            if (row == numRows - 1) {
                rp = -1;
                cp = 1;
            }
        }

        String r = "";
        for (int i = 0; i < rst.length; ++i) {
            for (int j = 0; j < rst[i].length; ++j) {
                if (rst[i][j] == null) {
                } else {
                    r = r + rst[i][j];
                }
            }
        }

        return r;
    }

    public static void main(String[] args) {
        new Solution().convert("dlcqsbbdjunbikbvuewnrwcugkqahmxkybbscevnyjoitpfpvcdmyhietzgalfkjindktzztkpcfghxblaqjjypezweld", 60);
//        new Solution().convert("012345678", 1);
//        new Solution().convert("012345678", 2);
//        new Solution().convert("012345678", 3);
//        new Solution().convert("0123456789abcdef", 4);
//        new Solution().convert("0123456789abcdef", 5);
//        new Solution().convert("0123456789abcdef", 6);
//        new Solution().convert("", 3);
    }
}
