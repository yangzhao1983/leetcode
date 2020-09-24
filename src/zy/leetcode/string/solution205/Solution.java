package zy.leetcode.string.solution205;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() == 0) return true;
        Map<Character,Character> s2T = new HashMap<>();
        Map<Character,Character> t2S = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if(!s2T.containsKey(si)){
                s2T.put(si, ti);
                if(t2S.containsKey(ti)) return false;
                else t2S.put(ti, si);
            }else{
                if(!s2T.get(s.charAt(i)).equals(t.charAt(i))) return false;
            }
        }
        return true;
    }
}
