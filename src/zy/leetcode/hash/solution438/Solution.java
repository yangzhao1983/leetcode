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
        for(int i = 0; i <= s.length() - p.length(); i++){
            if(isAnagram(s.substring(i, i + p.length()))) ans.add(i);
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
