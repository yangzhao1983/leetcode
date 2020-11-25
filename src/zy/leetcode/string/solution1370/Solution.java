package zy.leetcode.string.solution1370;

public class Solution {
    public String sortString(String s) {
        String ans = "";
        int[] cs = new int[26];
        for(char c: s.toCharArray()){
            cs[c - 'a']++;
        }
        int cnt = 0;
        int n = s.length();
        char[] rel = new char[n];
        while(cnt < n){
            for(int i = 0; i < 26; i++){
                if(cs[i] > 0) {
                    rel[cnt] = (char)('a' + i);
                    cnt++;
                    cs[i]--;
                }
            }
            for(int i = 25; i >=0; i--){
                if(cs[i] > 0) {
                    rel[cnt] = (char)('a' + i);
                    cnt++;
                    cs[i]--;
                }
            }
        }
        return String.valueOf(rel);
    }
}
