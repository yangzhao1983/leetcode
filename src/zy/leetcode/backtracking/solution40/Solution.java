package zy.leetcode.backtracking.solution40;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort candidates
        Arrays.sort(candidates);
        List<Integer> rel = new ArrayList<>();
        // backtracking
        backtracking(candidates, target, 0, rel);

        return ans;
    }

    private void backtracking(int[] candidates, int target, int start, List<Integer> rel){
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i] == target){
                rel.add(target);
                List<Integer> singleAns = new ArrayList<>();
                singleAns.addAll(rel);
                ans.add(singleAns);
                rel.remove(rel.size() - 1);
            }else if (candidates[i] < target){
                rel.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i+1, rel);
                rel.remove(rel.size() - 1);
            }else{
                return;
            }
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        List<List<Integer>> ans = sol.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);

        System.out.println();
    }

}
