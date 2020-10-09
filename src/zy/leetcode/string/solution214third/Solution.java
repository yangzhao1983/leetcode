package zy.leetcode.string.solution214third;

public class Solution {
    public String shortestPalindrome(String s) {
        if(s==null || s.length() <=1) return s;
        int[] next= getNext(s);
        int n = s.length();
        int j = -1;
        for(int i = n-1; i>=0;i--){
            while(j!=-1 && s.charAt(j + 1)!=s.charAt(i)){
                j = next[j];
            }
            if(s.charAt(j+1) == s.charAt(i)){
                j++;
            }
        }

        String add = j == n-1? "" : s.substring(j+1);
        StringBuilder sb = new StringBuilder(add).reverse();
        sb.append(s);
        return sb.toString();
    }

    private int[] getNext(String s){
        int n = s.length();
        int[] next = new int[n];
        int j = 0;

        for(int i = 2; i<n; i++){
            while(j!=0 && s.charAt(i-1)!= s.charAt(j)){
                j = next[j];
            }

            if(s.charAt(j) == s.charAt(i-1)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
