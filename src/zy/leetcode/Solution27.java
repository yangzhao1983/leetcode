package zy.leetcode;

/**
 * Created by kaiser_zhao on 02/05/2019.
 */
public class Solution27 {
    public static void main(String...strings){
        int[] nums = new int[]{1,2,3,4};
        System.out.println(removeElement(nums, 1));
        for(int num : nums){
            System.out.println(num);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if (nums[j]!=val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
