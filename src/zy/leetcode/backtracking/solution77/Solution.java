package zy.leetcode.backtracking.solution77;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> singleAns = new ArrayList<>();
    private int bottom;
    private int n;

    public List<List<Integer>> combine(int n, int k) {
        // if n=0 or k = 0, return empty list
        // if k > n, return the list
        // else return C(n,k), n*(n-1)*(n-k+1)/k!
        if(n == 0 || k == 0){
            return ans;
        }
        this.n = n;
        this.bottom = Math.min(n, k);

        backtracking(0, 0);

        return ans;
    }

    private void backtracking(int layer, int cur){
        if(layer == bottom){
            // get the rel
            List<Integer> got = new ArrayList<>();
            got.addAll(singleAns);
            ans.add(got);
            return;
        }
        for(int i = cur; i < n; i++){
            singleAns.add(i+1);
            backtracking(layer+1, i+1);
            singleAns.remove(singleAns.size()-1);
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        List<List<Integer>> ans = sol.combine(4,2);
        System.out.println();
    }
}
