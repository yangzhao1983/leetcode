package zy.leetcode.array.solution11;

import java.util.Map;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int max = 0;
        while(left < right){
            while(height[left] <= height[right] && left < right){
                int vol = Math.abs((right-left) * Math.min(height[left],height[right]));
                if(vol >max){
                    max = vol;
                }
                left++;
            }
            while(height[right] < height[left] && left < right){
                int vol = Math.abs((right-left) * Math.min(height[left],height[right]));
                if(vol >max){
                    max = vol;
                }
                right--;
            }
        }
        return max;
    }

    private static void test1(){
        Solution sol = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(sol.maxArea(height));
    }

    public static void main(String...strings){
        test1();
    }
}
