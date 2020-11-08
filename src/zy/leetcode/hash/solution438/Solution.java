package zy.leetcode.hash.solution438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<Character, Integer> map = new HashMap<>();

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s == null) return  ans;
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int scan = 0;
        int i = 0;
        while(i <= s.length() - p.length()){
            scan = 0;
            if(isAnagram(s.substring(i, i+p.length()))) {
                ans.add(i);
                int j = i + p.length();
                while(j+scan < s.length() && scan <p.length()){
                    if(s.charAt(i + scan) == s.charAt(j+scan)) ans.add(i+scan+1);
                    else break;
                    scan++;
                }
            }
            i = i + scan + 1;
        }

        return ans;
    }

    private boolean isAnagram(String str){
        Map<Character, Integer> tmp = new HashMap<>();
        tmp.putAll(map);
        for(char c: str.toCharArray()){
            if(!tmp.containsKey(c)){
                return false;
            }else{
                int cnt = tmp.get(c) - 1;
                tmp.put(c, cnt);
                if(cnt == 0) tmp.remove(c);
            }
        }
        return tmp.size() == 0;
    }
}
