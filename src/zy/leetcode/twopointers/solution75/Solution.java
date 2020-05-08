package zy.leetcode.twopointers.solution75;

import org.junit.Test;

public class Solution {
    /**
     * left, right
     *
     * left = 2
     * right = 2, right--
     * right =1, left<->right, right--
     * right = 0, left<->right, right--， left++
     *
     * left = 1
     * right =2,right--
     * right = 1, mid--, mid=2, mid<-->right, right--, mid=0, left<-->mid, left++
     *
     * left ==0 left++,
     * right=2 right--
     *
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        if(nums==null || nums.length <=1){
            return;
        }

        int left = 0;
        int right = nums.length-1;

        while(right > left && nums[right]==2){
            right--;
        }

        while(left < right){
            while(left < right && nums[left] == 0){
                left ++;
            }
            if (left == right) break;

            if(nums[left] == 2){
                swap(nums, left, right--);
            }else if(nums[left]==1){
                int mid = right;
                while(mid > left && nums[mid] ==1){
                    mid--;
                }
                if (left == right) break;

                if(nums[mid] == 0){
                    swap(nums, left++, mid);
                }else{
                    // == 2
                    swap(nums, mid, right--);
                }
            }
        }
    }

    private void swap(int[] nums, int from, int to){
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] nums = {2,0,2,1,1,0};
        sol.sortColors(nums);
        System.out.println();
    }
}
