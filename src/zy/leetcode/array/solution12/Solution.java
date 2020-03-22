package zy.leetcode.array.solution12;

import java.util.Collections;

public class Solution {
    public String intToRoman(int num) {
        char[][] romans = new char[4][2];
        romans[0][0] = 'I';
        romans[0][1] = 'V';
        romans[1][0] = 'X';
        romans[1][1] = 'L';
        romans[2][0] = 'C';
        romans[2][1] = 'D';
        romans[3][0] = 'M';

        String ans = "";
        int digit = 0;
        while(num>0){
            int curNum = num%10;
            if(curNum>0 && curNum<4){
                ans = String.join("", Collections.nCopies(curNum, String.valueOf(romans[digit][0]))) + ans;
            }else if(curNum == 5){
                ans = String.valueOf(romans[digit][1]) + ans;
            }else if(curNum == 4){
                ans = String.valueOf(romans[digit][0]) + String.valueOf(romans[digit][1]) + ans;
            }else if(curNum > 5 && curNum < 9){
                ans = String.valueOf(romans[digit][1]) + String.join("", Collections.nCopies(curNum-5, String.valueOf(romans[digit][0]))) + ans;
            }else if (curNum == 9){
                ans = String.valueOf(romans[digit][0]) + String.valueOf(romans[digit+1][0]) + ans;
            }
            num = num/10;
            digit++;
        }

        return ans;
    }

    private static void test1(){
        Solution sol = new Solution();
        System.out.println(sol.intToRoman(1994));
    }

    private static void test2(){
        Solution sol = new Solution();
        System.out.println(sol.intToRoman(10));
    }

    private static void test3(){
        Solution sol = new Solution();
        System.out.println(sol.intToRoman(58));
    }

    public static void main(String...strings){
//        test1();
//        test2();
        test3();
    }
}
