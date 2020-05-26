package zy.leetcode.sortandsearch.solution287;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * 1. mid
     * 2. [left, mid], [mid+1, right]
     * cal: sum = sum + 1<< (nums[i]-1)
     * 3. if num of '1' in sum < mid-left + 1, duplicated number is in this range,
     *    else, a[mid] = a[mid+1]
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while(l <= r){
            int count = 0;
            int mid = l + (r - l)/2;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    count++;
                }
            }
            if(count <= mid){
                l = mid + 1;
            }else{
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    @Test
    public void test1(){
        int[] nums = {1,2,2};
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.findDuplicate(nums));
    }

    @Test
    public void test2(){
        int[] nums = {3,1,3,4,2};
        Solution sol = new Solution();
        Assert.assertEquals(3, sol.findDuplicate(nums));
    }
}
