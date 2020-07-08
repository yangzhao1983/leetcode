package zy.leetcode.backtracking.solution131;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class Solution {
    private boolean[][] dp;
    private String s;
    private List<List<String>> ans = new ArrayList<>();
    /**
     * s->
     * map<string, List<pos>>
     * <p>
     * for each s[i,i+1], check if s[i, map.get[s[i,i+1]] is
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        if(s==null || s.length()==0){
            List<String> singleAns = new ArrayList<>();
            ans.add(singleAns);
            return ans;
        }
        dp = new boolean[s.length()][s.length()];
        this.s = s;

        // build dp for palindrome
        buildDp();
        doBacktracking(0, new ArrayList<>());

        return ans;
    }

    private void doBacktracking(int start, List<String> path){
        if(start == s.length()){
            List<String> single = new ArrayList<>();
            single.addAll(path);
            ans.add(single);
            return;
        }
        for(int i = start; i < dp[start].length; i++){
            if(dp[start][i]){
                path.add(s.substring(start,i+1));
                doBacktracking(i+1,path);
                path.remove(path.size()-1);
            }
        }
    }

    private void buildDp(){

        for(int i = 0; i < dp.length; i++){
            dp[i][i] = true;
        }
        List<Pair<Integer, Integer>> twoOrThree = new ArrayList<>();
        Map<String, LinkedList<Integer>> charPos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String cur = s.substring(i,i+1);
            if (!charPos.containsKey(cur)) {
                LinkedList<Integer> q = new LinkedList<>();
                q.addFirst(i);
                charPos.put(cur, q);
            }else{
                LinkedList<Integer> q = charPos.get(cur);

                int first = q.peekLast();
                if(i - first ==2 || i - first ==1) {
                    Pair<Integer, Integer> pair = new Pair<>(first, i);
                    twoOrThree.add(pair);
                }
                if(q.size() == 2){
                    q.pollLast();
                    int second = q.peekLast();
                    if(i - second ==2 || i - second ==1) {
                        Pair<Integer, Integer> pair = new Pair<>(second, i);
                        twoOrThree.add(pair);
                    }
                }
                q.addFirst(i);
            }
        }
        for(Pair<Integer, Integer> pair : twoOrThree){
            int start = pair.getKey();
            int end = pair.getValue();
            while(start >=0 && end < dp.length && s.substring(start, start+1).equals(s.substring(end, end+1))){
                dp[start][end] = true;
                dp[end][start] = true;
                start --;
                end ++;
            }
        }
    }

    @Test
    public void test1(){
        String s = "aab";
        Solution sol = new Solution();
        List<List<String>> ans = sol.partition(s);
        System.out.println();
    }

    @Test
    public void test2(){
        String s = "abbab";
        Solution sol = new Solution();
        List<List<String>> ans = sol.partition(s);
        System.out.println();
    }
}
