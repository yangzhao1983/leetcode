package zy.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaiser_zhao on 08/08/2019.
 */
public class Solution1 {
    public static void main(String...strings){
        for(int i : twoSum(new int[]{2,7,11,15}, 9)){
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(record.containsKey(nums[i])){
                return new int[]{record.get(nums[i]), i};
            }else{
                record.put(target-nums[i],i);
            }
        }
        return new int[] {-1, -1};
    }
}
