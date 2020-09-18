package zy.leetcode.backtracking.solution47again;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    private List<List<Integer>> ans = new ArrayList<>();
    private int n;
    private int[] nums;
    private boolean[] visitedIndex;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        visitedIndex = new boolean[n];
        doBacktracking(0, new ArrayList<>());
        return ans;
    }

    private void doBacktracking(int cur, List<Integer> path){
        if(cur == n){
            List<Integer> single = new ArrayList<>();
            single.addAll(path);
            ans.add(single);
            return;
        }
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(!visited.contains(nums[i]) && !visitedIndex[i]){
                visitedIndex[i] = true;
                path.add(nums[i]);
                doBacktracking(cur+1, path);
                path.remove(path.size() -1 );
                visited.add(nums[i]);
                visitedIndex[i] = false;
            }
        }
    }
}
