package zy.leetcode.twopointers.solution27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int toBeFilled = 0;
        int diff = 0;
        while(diff < nums.length){
            if(nums[diff]==val){
                diff++;
            }else{
                nums[toBeFilled++] = nums[diff++];
            }
        }
        return toBeFilled;
    }

    private static void test1(){
        Solution sol = new Solution();
        System.out.println(sol.removeElement(new int[]{3,2,2,3}, 3));
    }

    private static void test2(){
        Solution sol = new Solution();
        System.out.println(sol.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    public static void main(String...strings){
        test1();
        test2();
    }
}
