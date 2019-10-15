package zy.leetcode.array.solution1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaiser_zhao on 2019/10/15.
 */
public class SolByArray {

    public static void main(String...strings){
        int[] nums = {2,7,11,15};
        twoSum(nums, 9);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        Arrays.fill(ans, -1);

        // boundary value
        if(nums==null || nums.length <=1){
            return ans;
        }

        Map<Integer, Integer> leftToIndex = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            if(leftToIndex.containsKey(nums[i])){
                ans[0] = leftToIndex.get(nums[i]);
                ans[1] = i;
                break;
            }else{
                int left = target - nums[i];
                leftToIndex.put(left, i);
            }
        }
        return ans;
    }
}
