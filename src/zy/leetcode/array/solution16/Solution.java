package zy.leetcode.array.solution16;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i = 0; i<nums.length-2;i++){
            int L = i+1;
            int R = nums.length -1;
            int delta = 0;
            while(L < R){
                delta = nums[i] + nums[L] + nums[R]- target;

                if(delta == 0){
                    return target;
                }else if (delta > 0){
                    R--;
                }else{
                    L++;
                }
                if(Math.abs(min) > Math.abs(delta)){
                    min = delta;
                }
            }
        }
        return min + target;
    }

    private static void test1(){
        Solution sol = new Solution();
        System.out.println(sol.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    private static void test2(){
        Solution sol = new Solution();
        System.out.println(sol.threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
    }

    public static void main(String...strings){
        test1();
        test2();
    }
}
