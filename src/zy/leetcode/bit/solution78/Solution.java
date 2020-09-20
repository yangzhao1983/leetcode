package zy.leetcode.bit.solution78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> single = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < (1<<n); i++){
            single.clear();
            for(int j = 0 ; j < n; j++){
                if((i & (1 << j))>0) single.add(nums[j]);
            }

            ans.add(new ArrayList<Integer>(single));
        }
        return ans;
    }
}
