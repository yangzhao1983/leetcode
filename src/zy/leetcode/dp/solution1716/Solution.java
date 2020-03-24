package zy.leetcode.dp.solution1716;

public class Solution {
    public int massage(int[] nums) {
        if(nums == null || nums.length < 0) {
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }

        int[] ans = new int[nums.length+1];

        ans[0] = 0;
        ans[1] = nums[0];
        ans[2] = Math.max(nums[0], nums[1]);

        for(int i = 2; i<nums.length;i++){
            ans[i+1] = Math.max(ans[i-1], ans[i-2]) + nums[i];
        }

        return Math.max(ans[nums.length-1], ans[nums.length]);
    }

    private static void test1(){
        Solution sol = new Solution();
        System.out.println(sol.massage(new int[]{1,2,3,1}));
    }

    public static void main(String...strings){
        test1();
    }
}
