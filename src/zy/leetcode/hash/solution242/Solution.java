package zy.leetcode.hash.solution242;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c : t.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }else{
                int cnt = map.get(c)-1;
                map.put(c, cnt);
                if(cnt == 0) map.remove(c);
            }
        }
        return map.size() == 0;
    }
}
