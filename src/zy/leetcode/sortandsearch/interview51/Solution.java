package zy.leetcode.sortandsearch.interview51;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int reversePairs(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }

        int[] tmpNums = new int[nums.length];

        return reversePairs(nums, 0, nums.length-1, tmpNums);
    }

    private int reversePairs(int[] nums, int left, int right, int[] tmpNums){
        if(left == right){
            return 0;
        }
        int mid = left + (right - left)/2;
        int leftCount = reversePairs(nums, left, mid, tmpNums);
        int rightCount = reversePairs(nums, mid +1, right, tmpNums);

        if(nums[mid] <= nums[mid+1]){
            return leftCount + rightCount;
        }

        int crossCount = merge(nums, left, mid, right, tmpNums);

        return leftCount + rightCount + crossCount;
    }

    private int merge(int[] nums, int left, int mid, int right, int[] tmpNums){
        for(int m = left; m <= right; m++){
            tmpNums[m] = nums[m];
        }
        int count = 0;
        int i = left;
        int j = mid + 1;
        for(int k = left; k <= right; k++){
            if(i == mid+1){
                nums[k] = tmpNums[j++];
            }else if(j == right+1){
                nums[k] = tmpNums[i++];
            }else if(tmpNums[i] <= tmpNums[j]){
                nums[k] = tmpNums[i++];
            }else{
                nums[k] = tmpNums[j++];
                count += mid - i + 1;
            }
        }
        return count;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(5, sol.reversePairs(new int[]{7,5,6,4}));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals(4, sol.reversePairs(new int[]{1,3,2,3,1}));
    }
}
