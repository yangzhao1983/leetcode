package zy.leetcode.search.solution34;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[]{-1,-1};
        }
        return doSearchRange(nums, 0, nums.length-1, target);
    }

    private int[] doSearchRange(int[] nums, int left, int right, int target){
        if(left==right){
            if(nums[left] == target){
                return new int[]{left, left};
            }else{
                return new int[]{-1, -1};
            }
        }

        int mid = left + (right-left)/2;
        int[] leftRange = doSearchRange(nums, left, mid,target);
        int[] rightRange = doSearchRange(nums, mid+1, right,target);
        mergeRange(leftRange,rightRange);
        return leftRange;
    }

    private void mergeRange(int[] src, int[] tgt){
        if(src[0]==-1 || (tgt[0] < src[0] && tgt[0] > -1)){
            src[0] = tgt[0];
        }

        if(tgt[1] > src[1]){
            src[1] = tgt[1];
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] ans = sol.searchRange(new int[]{5,7,7,8,8,10}, 8);
        Assert.assertArrayEquals(new int[]{3,4}, ans);
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        int[] ans = sol.searchRange(new int[]{5,7,7,8,8,10}, 6);
        Assert.assertArrayEquals(new int[]{-1,-1}, ans);
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        int[] ans = sol.searchRange(new int[]{}, 0);
        Assert.assertArrayEquals(new int[]{-1,-1}, ans);
    }

    @Test
    public void test4(){
        Solution sol = new Solution();
        int[] ans = sol.searchRange(new int[]{8}, 8);
        Assert.assertArrayEquals(new int[]{0,0}, ans);
    }
}
