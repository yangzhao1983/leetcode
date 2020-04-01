package zy.leetcode.backtracking.solution39;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> rel = new ArrayList<>();
        backtracking(candidates, target, rel);
        return ans;
    }

    private List<List<Integer>> ans = new ArrayList<>();
    /**
     * loop candidates:
     *  if c <= combination.last, continue
     *  if c = target, combination.add(c), copy, add copy to ans. remove c from combination. return
     *  else, backtracking(candidates, target -c, combination.add(c))
     *      combination.remove(c)
     *
     * @param candidates
     * @param target
     * @param combination
     */
    private void backtracking(int[] candidates, int target, List<Integer> combination){
        Set<Integer> visited = new HashSet<>();
        for(int candidate : candidates){
            if(visited.contains(candidate)){
                continue;
            }else{
                visited.add(candidate);
            }
            if( combination.size()> 0 && candidate < combination.get(combination.size()-1)){
                continue;
            }else if(candidate == target){
                combination.add(target);
                List<Integer> rel = new ArrayList<>();
                rel.addAll(combination);
                ans.add(rel);
                combination.remove(combination.size()-1);
            }else if (target > candidate) {
                combination.add(candidate);
                backtracking(candidates, target - candidate, combination);
                combination.remove(combination.size() - 1);
            }
        }
    }

    @Test
    public void test1(){
        int[] candidates = {2,3,6,7};
        int target = 7;
        Solution sol = new Solution();
        List<List<Integer>> list = sol.combinationSum(candidates, target);

        List<Integer> expC1 = new ArrayList<>();
        expC1.add(7);

        List<Integer> expC2 = new ArrayList<>();
        expC2.add(2);
        expC2.add(2);
        expC2.add(3);
    }

    @Test
    public void test2(){
        int[] candidates = {2,3,3,2};
        int target = 7;
        Solution sol = new Solution();
        List<List<Integer>> list = sol.combinationSum(candidates, target);

        List<Integer> expC1 = new ArrayList<>();
        expC1.add(7);

        List<Integer> expC2 = new ArrayList<>();
        expC2.add(2);
        expC2.add(2);
        expC2.add(3);
    }
}
