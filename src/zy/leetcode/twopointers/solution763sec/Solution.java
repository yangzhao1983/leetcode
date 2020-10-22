package zy.leetcode.twopointers.solution763sec;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] end = new int[26];
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            end[ c -'a'] = Math.max(end[c-'a'], i);
        }
        int s = 0, e= 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i< S.length(); i++){
            e = Math.max(end[S.charAt(i) - 'a'], e);
            if(i==e){
                ans.add(e - s + 1);
                s = e + 1;
            }
        }
        return ans;
    }
}
