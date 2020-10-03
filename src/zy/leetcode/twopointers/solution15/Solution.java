package zy.leetcode.twopointers.solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int k = nums.length-1;
            for(int j = i+1; j <= k-1; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                while(k > j){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> rel = new ArrayList<>();
                        rel.add(nums[i]);
                        rel.add(nums[j]);
                        rel.add(nums[k]);
                        ans.add(rel);
                        k--;
                        break;
                    }else if(nums[i] + nums[j] + nums[k] > 0){
                        k--;
                    }else{
                        break;
                    }

                }

            }
        }

        return ans;
    }
}
