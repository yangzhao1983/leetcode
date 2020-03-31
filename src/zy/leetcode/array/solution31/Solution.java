package zy.leetcode.array.solution31;

public class Solution {
    public void nextPermutation(int[] nums) {
        // a[n], if a[m],a[m+1],..a[n] desc
        // swap a[m-1], a[k], a[k]: Min(a[j]>a[m]), n>=j>m
        // reverse a[m],a[n]
        int i = nums.length-1;
        for(; i >0; i--){
            if(nums[i]>nums[i-1]){
               break;
            }
        }
        if(i > 0){
            int j = i;
            for(;j<nums.length-1;j++){
                if(nums[j+1]<=nums[i-1]){
                    break;
                }
            }
            int tmp = nums[j];
            nums[j] = nums[i-1];
            nums[i-1] = tmp;
        }

        reverse(nums, i, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end){
        int mid = start + (end-start)/2;
        for(int i = start; i <= mid; i++){
            int tmp = nums[i];
            nums[i] = nums[end - (i-start)];
            nums[end - (i-start)] = tmp;
        }
    }

    private static void test1(){
        int[] nums = new int[]{1,2,3};
        Solution sol = new Solution();
        sol.nextPermutation(nums);
        for(int num : nums){
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }
    private static void test2(){
        int[] nums = new int[]{1,1,5};
        Solution sol = new Solution();
        sol.nextPermutation(nums);
        for(int num : nums){
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void test3(){
        int[] nums = new int[]{1,3,2};
        Solution sol = new Solution();
        sol.nextPermutation(nums);
        for(int num : nums){
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void test4(){
        int[] nums = new int[]{3,2,1};
        Solution sol = new Solution();
        sol.nextPermutation(nums);
        for(int num : nums){
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
        test4();
    }

    /**
     * 12345
     * 12354
     * 12435
     * 12453
     * 12534
     * 12543
     * 13245
     * 13254
     * 13425
     * 13452
     * 13524
     * 13542
     *
     */
}
