package zy.leetcode.backtracking.solution90;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private List<Integer> rel = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        doBacktracking(nums, 0);
        return ans;
    }

    /**
     * nums has been sored
     *
     * initial status: subset = {}
     * add nums[i] to it, nums[i] can not be added to subset again.
     * so can only select next item from nums[i+1..len-1].
     *
     * each selection will create a branch. if nums[k] =nums[k+1], then nums[k+1] should be ignored as a branch.
     *
     * if a branch get created, then a subset is created.
     *
     * @param nums
     * @param start
     */
    private void doBacktracking(int[] nums, int start){
        int last = 0;
        boolean gotLast = false;
        for(int i = start; i < nums.length; i++){
            if(gotLast && nums[i] == last){
                continue;
            }
            rel.add(nums[i]);
            List<Integer> single = new ArrayList<>();
            single.addAll(rel);
            ans.add(single);
            doBacktracking(nums, i+1);
            last = rel.remove(rel.size()-1);
            gotLast = true;
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] nums = {1,2,2};
        List<List<Integer>> ans = sol.subsetsWithDup(nums);
        System.out.println();
    }
}
