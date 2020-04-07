package zy.leetcode.backtracking.solution47;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private boolean[] visited;
    private List<Integer> list =new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        backtracking(nums);
        return ans;
    }

    private void backtracking(int[] nums){
        if(list.size() == nums.length){
            List<Integer> singleAns = new ArrayList<>();
            singleAns.addAll(list);
            ans.add(singleAns);
            return;
        }

        Set<Integer> dup = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || dup.contains(nums[i])){
                continue;
            }
            dup.add(nums[i]);
            visited[i] = true;
            list.add(nums[i]);
            backtracking(nums);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }

    @Test
    public void test1(){
        int[] nums = {1,1,2};
        Solution sol = new Solution();
        List<List<Integer>> ans = sol.permuteUnique(nums);
        System.out.println();
    }
}
