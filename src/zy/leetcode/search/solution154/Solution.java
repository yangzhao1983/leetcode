package zy.leetcode.search.solution154;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int findMin(int[] nums) {
        return doBinarySearch(nums, 0, nums.length-1);
    }

    private int doBinarySearch(int[] nums, int l, int r){
        if(l==r)return nums[l];
        else if (l+1==r) return Math.min(nums[l], nums[r]);

        // mid
        int mid = l + (r-l)/2;
        // 1. nums[l] < nums[mid] && nums[r] > nums[mid] return nums[l]
        // 2. nums[l] < nums[mid] && nums[r] < nums[mid]  search [mid, r]
        // 3. nums[l] > nums[mid] && nums[r] > nums[mid] search [l, mid]
        // 4. nums[l] > nums[mid] && nums[r] < nums[mid] impossible
        // 5. nums[l] == nums[mid] && nums[r] == nums[mid] search two range
        // 6. nums[l] == nums[mid] && nums[r] > nums[mid] return nums[l]
        // 7. nums[l] == nums[mid] && nums[r] < nums[mid] search [mid, r]
        // 8. nums[l] > nums[mid] && nums[r] == nums[mid] search [l,mid]
        // 9. nums[l] < nums[mid] && nums[r] == nums[mid] return nums[l]
        if(nums[r] > nums[mid] && nums[l] <= nums[mid]){
            return nums[l];
        }else if((nums[r] < nums[mid] && nums[l] <= nums[mid])){
            return doBinarySearch(nums, mid, r);
        }else if(nums[l] > nums[mid] && nums[r] >= nums[mid]){
            return doBinarySearch(nums, l, mid);
        }else{
            int first = doBinarySearch(nums, l, mid);
            int second = doBinarySearch(nums, mid, r);
            return Math.min(first, second);
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(1,sol.findMin(new int[]{3,3,1,3}));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals(0,sol.findMin(new int[]{2,0,1,1,1}));
    }
}
