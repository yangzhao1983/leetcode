package zy.leetcode.backtracking.solution216;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private int LIMIT = 9;
    private int k;
    private int n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.n = n;
        this.k = k;
        doBacktracking(1, 0, new ArrayList<>());
        return ans;
    }

    private void doBacktracking(int cur, int sum, List<Integer> single){

        if(sum > n){
            return;
        }else if(single.size() ==k){
            if(sum == n){
                List<Integer> path = new ArrayList<>();
                path.addAll(single);
                ans.add(path);
            }
            return;
        }

        if(cur > LIMIT){
            return;
        }

        for(int i = cur; i <= LIMIT; i++){
            sum += i;
            single.add(i);
            doBacktracking(i+1, sum, single);
            sum -= i;
            single.remove(single.size()-1);
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        List<List<Integer>> ans = sol.combinationSum3(3,7);
        System.out.println();
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        List<List<Integer>> ans = sol.combinationSum3(3,15);
        System.out.println();
    }
}
