package zy.leetcode.array.solution30;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if(s==null || s.length()==0 || words==null || words.length==0){
            return ans;
        }

        Map<String, Integer> sMap = new HashMap<>();
        Map<String, Integer> wMap = new HashMap<>();
        int wordLen = words[0].length();
        for(String word : words){
            wMap.put(word, wMap.getOrDefault(word, 0 ) +1);
        }

        for(int i = 0; i <= s.length() - words.length * wordLen; i++){
            int j = i;
            sMap.clear();
            for(; j < (i + words.length * wordLen); j=j+wordLen){
                int curEnd = j +wordLen;
                sMap.put(s.substring(j, curEnd), sMap.getOrDefault(s.substring(j, curEnd), 0 ) +1);
                if(sMap.get(s.substring(j, curEnd)) > wMap.getOrDefault(s.substring(j, curEnd),0)){
                    break;
                }
            }
            if(j == i + words.length * wordLen){
                ans.add(i);
            }
        }
        return ans;
    }

    private static void test1(){
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        Solution sol = new Solution();
        System.out.println(sol.findSubstring(s, words));
    }

    private static void test2(){
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        Solution sol = new Solution();
        System.out.println(sol.findSubstring(s, words));
    }

    public static void main(String...strings){
//        test1();
        test2();
    }
}
