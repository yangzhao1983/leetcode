package zy.leetcode;

/**
 * Created by kaiser_zhao on 15/06/2019.
 */
public class DP {

    public static void main(String...strings){
        int[] nums = new int[5];
        nums[0] = -1;
        nums[1] = 2;
        nums[2] = -2;
        nums[3] = 2;
        nums[4] = 2;
        System.out.println(getMaxSeqSum(nums));
    }

    public static int getMaxSeqSum(int[] nums){
        return doDp(nums, nums.length-1);
    }

    // dp[i] = max(dp[i-1] + nums[i], nums[i])
    public static int doDp(int[] nums, int cur){
        if (cur == 0){
            return nums[0];
        }
        return getMax(doDp(nums, cur-1) + nums[cur], nums[cur]);
    }

    private static int getMax(int first, int second){
        return first > second ? first : second;
    }
}
