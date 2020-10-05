package zy.leetcode.twopointers.solution18sec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null || nums.length < 4) return ans;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i]==nums[i-1]) continue;
            int sum3 = target - nums[i];
            for(int j = i+1; j < nums.length - 2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int sum2 = sum3 - nums[j];
                int l = j+1;
                int m = nums.length - 1;
                while(l < m){
                    int sum = nums[l] + nums[m];
                    if(l > j+1 && nums[l] == nums[l-1]){
                        l++;
                        continue;
                    }
                    if( sum > sum2) m--;
                    else if (sum <sum2)l++;
                    else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[m]);
                        ans.add(list);
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}
