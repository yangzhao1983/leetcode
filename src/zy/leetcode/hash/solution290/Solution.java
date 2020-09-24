package zy.leetcode.hash.solution290;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if(pattern.length() != ss.length) return false;
        Map<String, String> p2S = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            String pSub = pattern.substring(i, i+1);
            String sSub = ss[i];
            if(p2S.containsKey(pSub)){
                if(!p2S.get(pSub).equals(sSub)) return false;
            }else{
                if(p2S.values().contains(ss[i])) return false;
                else p2S.put(pSub, sSub);
            }
        }
        return true;
    }
}
