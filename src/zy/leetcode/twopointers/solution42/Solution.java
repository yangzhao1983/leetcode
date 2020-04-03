package zy.leetcode.twopointers.solution42;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int trap(int[] height) {
        // int[] index 0-len-1, sort it by height
        // find the highest one->mid
        // find left max, sum the vol
        // find right max, sum the vol, util mid = 0 or len
        Integer[] indices = new Integer[height.length];
        for(int i = 0; i<height.length; i++){
            indices[i] = i;
        }
        Arrays.sort(indices, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return height[o2] - height[o1];
            }
        });
        int ans = 0;
        int mid = 0;
        // left
        while(mid < height.length){
            int left = mid + 1;
            while(left < height.length && indices[left] > indices[mid]){
                left++;
            }

            if(left == height.length){
                break;
            }

            // sum
            for(int i = indices[left] + 1 ; i<= indices[mid]-1; i++){
                ans += height[indices[left]] - height[i];
            }
            mid = left;
        }
        // right
        mid = 0;
        while(mid < height.length){
            int right = mid + 1;
            while(right < height.length && indices[right] < indices[mid]){
                right ++;
            }

            if(right == height.length){
                break;
            }

            // sum
            for(int i = indices[mid] + 1 ; i<= indices[right]-1; i++){
                ans += height[indices[right]] - height[i];
            }
            mid = right;
        }
        return ans;
    }

    @Test
    public void test1(){
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution sol = new Solution();
        Assert.assertEquals(6, sol.trap(nums));
    }
}
