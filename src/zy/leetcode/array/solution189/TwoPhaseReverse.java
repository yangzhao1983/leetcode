package zy.leetcode.array.solution189;

/**
 * Created by kaiser_zhao on 2019/9/2.
 */
public class TwoPhaseReverse {

    public static void main(String...strings){
        testcase3();
    }

    private static void testcase1(){
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        for(int i : nums){
            System.out.println(i);
        }
    }

    private static void testcase3(){
        int[] nums = {1,2,3};
        rotate(nums, 4);
        for(int i : nums){
            System.out.println(i);
        }
    }

    private static void testcase2(){
        int[] nums = {1,2};
        rotate(nums, 3);
        for(int i : nums){
            System.out.println(i);
        }
    }

    public static void rotate(int[] nums, int k) {
        if(nums == null || nums.length <=1){
            return;
        }
        if(k%nums.length == 0){
            return;
        }

        int kMod = k % nums.length;

        // separate nums to two parts A (len - k) and B (k)
        // reverse A =>A', and reverse B=>B' O(n)
        reverse(nums, 0, nums.length - kMod -1);
        reverse(nums, nums.length -kMod, nums.length-1);

        // reverse whole A'B' O(n)
        reverse(nums, 0, nums.length -1);
    }

    private static void reverse(int[] nums, int start, int end){
        int mid = start + (end -start)/2;
        int tmp = 0;
        for(int i = start; i <= mid; i++){
            tmp = nums[i];
            nums[i] = nums[end-i+start];
            nums[end-i+start] = tmp;
        }
    }
}
