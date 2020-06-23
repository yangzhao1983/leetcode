package zy.leetcode.string.solution67;

public class Solution {
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int len = Math.max(a.length(), b.length());
        int carry = 0;
        for(int i = 0; i<len; i++){
            if(i < b.length()) carry += b.charAt(b.length() - i -1) - '0';
            if(i < a.length()) carry += a.charAt(a.length()-i-1) - '0';
            sb.append(carry%2 == 1 ? "1" : "0");
            carry /=2;
        }

        if(carry > 0) sb.append("1");

        return sb.reverse().toString();
    }
}
