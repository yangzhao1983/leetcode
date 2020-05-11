package zy.leetcode.backtracking.solution78;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> singleAns = new ArrayList<>();
    private int bottom;
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums != null && nums.length > 0) {
            this.bottom = nums.length;
            this.nums = nums;
            backtracking(0, 0);
        }

        return ans;
    }

    private void backtracking(int cur, int layer) {

        List<Integer> got = new ArrayList<>();
        got.addAll(singleAns);
        ans.add(got);

        if (layer == bottom) {
            return;
        }

        for (int i = cur; i < bottom; i++) {
            singleAns.add(nums[i]);
            backtracking(i + 1, layer + 1);
            singleAns.remove(singleAns.size() - 1);
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> ans = sol.subsets(nums);
        System.out.println();
    }
}
