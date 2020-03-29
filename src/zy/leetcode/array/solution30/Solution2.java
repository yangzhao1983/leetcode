package zy.leetcode.array.solution30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if(s==null || s.length()==0 || words==null || words.length==0){
            return ans;
        }
        Map<String, Integer> wMap = new HashMap<>();
        Map<String, Integer> sMap = new HashMap<>();

        for(String word : words){
            wMap.put(word, wMap.getOrDefault(word, 0 )  + 1);
        }

        int wordLen = words[0].length();
        for(int start = 0; start < wordLen; start++){
            sMap.clear();
            int j = start;
            String removed = "";
            for(; j <= s.length() - words.length * wordLen;j+=wordLen){
                if(j==start){
                    int curStart = j;
                    for(; curStart < j + words.length * wordLen; curStart+=wordLen){
                        int curEnd = curStart +wordLen;
                        sMap.put(s.substring(curStart, curEnd),sMap.getOrDefault(s.substring(curStart, curEnd),0)+1);
                    }
                }else{
                    // add new item into map
                    int lastStart = j +  words.length * wordLen - wordLen;
                    String lastWord = s.substring(lastStart, lastStart + wordLen);
                    sMap.put(lastWord, sMap.getOrDefault(lastWord,0)+1);
                }

                // compare with words
                boolean match = true;
                for(String sWord : sMap.keySet()){
                    if(sMap.get(sWord) != wMap.getOrDefault(sWord,0)){
                        match = false;
                        break;
                    }
                }
                if(match){
                    ans.add(j);
                }

                // remove first word from map
                removed = s.substring(j, j + wordLen);
                sMap.put(removed, sMap.get(removed) -1 );
            }
        }
        return ans;
    }

    private static void test1(){
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        Solution2 sol = new Solution2();
        System.out.println(sol.findSubstring(s, words));
    }

    private static void test2(){
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        Solution2 sol = new Solution2();
        System.out.println(sol.findSubstring(s, words));
    }

    public static void main(String...strings){
        test1();
        test2();
    }
}
