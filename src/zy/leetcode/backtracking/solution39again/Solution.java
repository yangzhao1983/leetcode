package zy.leetcode.backtracking.solution39again;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        doBacktracking(candidates, 0, new ArrayList<>(), 0);
        return ans;
    }

    private void doBacktracking(int[] candidates, int cur, List<Integer> list, int sum){
        if(sum == target){
            List<Integer> single = new ArrayList<>();
            single.addAll(list);
            ans.add(single);
            return;
        }else if(sum > target){
            return;
        }

        for(int i = cur; i < candidates.length; i++){
            list.add(candidates[i]);
            sum = sum + candidates[i];
            doBacktracking(candidates, i, list, sum);
            list.remove(list.size()-1);
            sum = sum - candidates[i];
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] candidates = {2,3,6,7};
        List<List<Integer>> ans = sol.combinationSum(candidates, 7);
        System.out.println();
    }
}
