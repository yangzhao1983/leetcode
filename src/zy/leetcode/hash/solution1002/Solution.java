package zy.leetcode.hash.solution1002;

import java.util.*;

public class Solution {
    public List<String> commonChars(String[] A) {
        int[] sum = new int[26];
        Arrays.fill(sum, Integer.MAX_VALUE);
        int[] single;
        for(String a : A){
            single = new int[26];
            for(int i = 0; i < a.length(); i++){
                char c = a.charAt(i);
                single[c-'a']++;
            }
            for(int i = 0; i < 26; i++){
                sum[i] = Math.min(sum[i], single[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            int cnt = sum[i];
            if(cnt < Integer.MAX_VALUE){
                while(cnt-- >0){
                    ans.add(String.valueOf((char) (i + 'a')));
                }
            }
        }
        return ans;
    }
}
