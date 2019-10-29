package zy.leetcode;

/**
 * Created by kaiser_zhao on 01/05/2019.
 */
public class Solution26 {
    public static void main(String...strings){
        int[] nums = new int[]{1,2,2,3};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for(int i : nums){
            System.out.println(i);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1){
            return 1;
        }
        int curInputIndex = 1;
        int preValue = nums[0];
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == preValue){
                continue;
            }else{
                nums[curInputIndex++] = nums[i];
                preValue = nums[i];
            }
        }
        return curInputIndex;
    }
}
