package zy.leetcode.backtracking.solution140;

import org.junit.Test;

import java.util.*;

public class Solution {
    private Set<String> words = new HashSet<>();
    private List<String> ans = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return ans;

        for (String word : wordDict) {
            words.add(word);
        }
        List<String> path = new ArrayList<>();
        doBacktracking(path, s, 0);
        return ans;
    }

    private String joinStr(List<String> list){
        if(list.size()==0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for(int i = 1; i < list.size();i++){
            sb.append(" ");
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    private void doBacktracking(List<String> path, String s, int start) {
        if (start == s.length())
            ans.add(joinStr(path));
        else {
            for (int i = start + 1; i <= s.length(); i++) {
                String cur = s.substring(start, i);
                if (words.contains(cur)) {
                    path.add(cur);
                    doBacktracking(path, s, i);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    @Test
    public void test1(){
        String s = "catsanddog";
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        Solution sol = new Solution();
        List<String> ans = sol.wordBreak(s, list);
        System.out.println();
    }
}
