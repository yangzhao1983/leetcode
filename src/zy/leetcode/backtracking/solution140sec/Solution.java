package zy.leetcode.backtracking.solution140sec;

import java.util.*;

public class Solution {
    private Map<Integer, List<String>> map = new HashMap<>();
    private Set<String> set = new HashSet<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String word : wordDict){
            set.add(word);
        }

        return doBacktracking(s, 0);
    }

    private List<String> doBacktracking(String s, int start){
        if(map.containsKey(start)) return map.get(start);
        List<String> rel = new ArrayList<>();
        if(start == s.length()){
            rel.add("");
        }

        for(int i = start+1; i <= s.length(); i++){
            String cur = s.substring(start, i);
            if(set.contains(cur)){
                List<String> list = doBacktracking(s, i);
                for (String l : list) {
                    rel.add(s.substring(start, i) + (l.equals("") ? "" : " ") + l);
                }
            }
        }

        map.put(start, rel);
        return rel;
    }
}
