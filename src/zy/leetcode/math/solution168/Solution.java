package zy.leetcode.math.solution168;

public class Solution {
    public String convertToTitle(int n) {
        String ans = "";
        while(n > 0){
            n--;
            int num = n%26;
            char c = (char)(num + 'A');
            ans = String.valueOf(c) + ans;
            n /= 26;
        }
        return  ans;
    }
}
