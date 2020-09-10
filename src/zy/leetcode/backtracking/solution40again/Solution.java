package zy.leetcode.backtracking.solution40again;

import java.util.*;

public class Solution {

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        doBacktracking(candidates, target, 0, 0, new ArrayList<>());
        return ans;
    }

    private void doBacktracking(int[] candidates, int target, int sum, int cur, List<Integer> single){
        if(sum == target){
            List<Integer> combination = new ArrayList<>();
            combination.addAll(single);
            ans.add(combination);
            return;
        }else if(sum > target) return;
        else if(cur == candidates.length) return;

        Set<Integer> visited = new HashSet<>();
        for(int i = cur; i < candidates.length; i++){
            if(visited.contains(candidates[i])) continue;
            else visited.add(candidates[i]);
            sum += candidates[i];
            single.add(candidates[i]);
            doBacktracking(candidates, target, sum, i+1, single);
            single.remove(single.size()-1);
            sum -= candidates[i];
        }
    }
}
