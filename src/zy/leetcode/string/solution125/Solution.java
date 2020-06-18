package zy.leetcode.string.solution125;

public class Solution {

    private String s;

    public boolean isPalindrome(String s) {
        if(s==null || s.length() == 0){
            return true;
        }

        this.s = s;
        boolean ans = true;
        int l = 0;
        int r = s.length() - 1;
        while(l<r){
            while(l < r && !isAlphanumeric(l))l++;
            while(l< r && !isAlphanumeric(r))r--;
            if(l >= r) break;
            if(!ignoreCaseEqual(s.charAt(r), s.charAt(l))){
                ans = false;
                break;
            }else{
                l++;
                r--;
            }
        }
        return ans;
    }

    private boolean ignoreCaseEqual(char c1, char c2){
        return Character.toUpperCase(c1) == Character.toUpperCase(c2);
    }

    private boolean isAlphanumeric(int index){
        char c = s.charAt(index);
        return (Character.isDigit(c) || Character.isLetter(c));
    }
}
