package zy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaiser_zhao on 24/09/2018.
 */
public class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        indices[0] = -1;
        indices[1] = -1;

        if(nums == null || nums.length <3 ){
            return indices;
        }

        for(int i = 0; i<nums.length;i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    indices[0] = i;
                    indices[1] = j;
                    break;
                }
            }
        }
        return indices;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] indices = new int[2];
        indices[0] = -1;
        indices[1] = -1;

        if(nums == null || nums.length <2 ){
            return indices;
        }

        Map<Integer, Integer> storeMap = new HashMap<>();

        for(int i = 0; i<nums.length;i++){
            int target1 = nums[i];
            int target2 = target - target1;
            if(storeMap.containsKey(target2)){
                indices[0] = i;
                indices[1] = storeMap.get(target2);
            }else{
                storeMap.put(target1, i);
            }
        }

        return indices;
    }

    public final static void main(String...strings){
        int[] twoSum = {3,4,3};
        int target = 6;
        int[] rel = twoSum2(twoSum, target);
        System.out.println( "twoSum[" + rel[0] + "]+ twoSum[" + rel[1] + "]=" + target);
    }
}
