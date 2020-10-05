package zy.leetcode.string.solution415;

public class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length()-1;
        int n = num2.length()-1;
        String ans = "";
        int carry = 0;
        while(m >= 0 && n >=0){
            int sum = (num1.charAt(m) - '0') + (num2.charAt(n)-'0') + carry;
            carry = sum/10;
            sum %= 10;
            ans = String.valueOf(sum) + ans;
            m--;
            n--;
        }
        String left = null;
        int index = -1;
        if(m >= 0){
            left = num1;
            index = m;
        }else if(n >=0){
            left = num2;
            index = n;
        }
        while(index >=0){
            int sum = (left.charAt(index) - '0') + carry;
            carry = sum/10;
            sum %= 10;
            ans = String.valueOf(sum) + ans;
            index--;
        }
        if(carry == 1) ans = "1" + ans;
        return ans;
    }
}
