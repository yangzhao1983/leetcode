package zy.leetcode.array.solution228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums==null || nums.length ==0) return ans;

        String s = String.valueOf(nums[0]);
        int pre = nums[0];

        int n = nums.length;
        for(int i = 1; i<n; i++){
            if(nums[i] - nums[i-1] != 1){
                if(pre != nums[i-1]){
                    s += "->";
                    s += String.valueOf(nums[i-1]);
                }
                ans.add(s);
                pre = nums[i];
                s = String.valueOf(nums[i]);
            }
        }
        if(pre != nums[n-1]){
            ans.add(s + "->" + nums[n-1]);
        }else{
            ans.add(s);
        }
        return ans;
    }
}
