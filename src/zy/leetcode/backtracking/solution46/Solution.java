package zy.leetcode.backtracking.solution46;

import org.junit.Test;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null || nums.length==0){
            return ans;
        }
        backTracking(nums,new HashSet<Integer>(), new ArrayList<Integer>());
        return ans;
    }

    private void backTracking(int[] nums, Set<Integer> visited, List<Integer> singleAns){
        if(visited.size() == nums.length){
            List<Integer> list = new ArrayList<>();
            list.addAll(singleAns);
            ans.add(list);
        }else{
            for(int i = 0; i < nums.length;i++){
                if(!visited.contains(nums[i])){
                    singleAns.add(nums[i]);
                    visited.add(nums[i]);
                    backTracking(nums,visited,singleAns);
                    visited.remove(nums[i]);
                    singleAns.remove(singleAns.size() - 1);
                }
            }
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> ans = sol.permute(nums);
        System.out.println("   ");
    }
}
