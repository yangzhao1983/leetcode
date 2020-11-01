package zy.leetcode.backtracking.solution472;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private Set<String> set;
    private List<String> ans;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        ans = new ArrayList<>();
        set = new HashSet<>();
        for(String word : words){
            set.add(word);
        }
        for(String word : words){
            doBacktracking(word, 0, 0);
        }
        return ans;
    }

    private void doBacktracking(String word, int start, int cnt){
        if(ans.contains(word)){
            return;
        }
        if(start == word.length() && cnt > 1) {
            ans.add(word);
            return;
        }
        for(int i = word.length(); i > start;i--){
            if(set.contains(word.substring(start, i))){
                cnt++;
                doBacktracking(word, i, cnt);
                cnt--;
            }
        }
    }
}

