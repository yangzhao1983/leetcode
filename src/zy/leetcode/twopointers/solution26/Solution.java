package zy.leetcode.twopointers.solution26;

public class Solution {
    /**
     * first_pointer = i
     * while nums[i]==nums[i+1], i++
     *
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int indexToBeFilled = 1;
        int indexDiff = 1;
        while(indexDiff<nums.length){
            while(indexDiff < nums.length && nums[indexDiff]==nums[indexDiff-1]){
                indexDiff++;
            }
            if(indexDiff<nums.length){
                nums[indexToBeFilled++] = nums[indexDiff++];
            }
        }

        return indexToBeFilled;
    }

    private static void test1(){
        int[] nums = new int[]{1,1,2};
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates(nums));
    }

    private static void test2(){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates(nums));
    }

    private static void test3(){
        int[] nums = new int[]{1,2,3};
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates(nums));
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
    }
}
