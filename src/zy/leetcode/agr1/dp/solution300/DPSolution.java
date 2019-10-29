package zy.leetcode.agr1.dp.solution300;

/**
 * Created by kaiser_zhao on 2019/9/18.
 */
public class DPSolution {
    public static void main(String...strings){
        testcase1();
        testcase2();
    }

    private static void testcase1(){
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }

    private static void testcase2(){
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        // get the array
        if(nums==null){
            return 0;
        }else if(nums.length < 2){
            return nums.length;
        }

        int[] liss = new int[nums.length];

        liss[0] = 1;

        for(int i = 1; i<nums.length; i++){
            int j = i - 1;
            int maxLength = Integer.MIN_VALUE;
            int maxIndex = -1;
            for(; j>=0; j--){
                if(nums[i] > nums[j]){
                    if(liss[j] > maxLength){
                        maxLength = liss[j];
                        maxIndex = j;
                    }
               }
           }
           if(maxLength > Integer.MIN_VALUE){
               liss[i] = liss[maxIndex] + 1;
           }else{
               liss[i] = 1;
           }
        }

        // find the longest length
        int longestLength = Integer.MIN_VALUE;
        for(int i = 0; i < liss.length; i++){
            if(liss[i] > longestLength){
                longestLength = liss[i];
            }
        }

        return longestLength;
    }
}
