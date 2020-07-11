package zy.leetcode.array.solution315;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i =0 ;i <nums.length; i++){
            int cnt = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] <nums[i]) cnt++;
            }
            ans.add(cnt);
        }
        return ans;
    }
}
