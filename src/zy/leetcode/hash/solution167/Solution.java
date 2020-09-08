package zy.leetcode.hash.solution167;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] * 2 > target) break;
            map.put(target - numbers[i], i);
        }
        int[] ans = new int[2];
        for(int i = 0; i <numbers.length; i++){
            if(map.containsKey(numbers[i]) && i != map.get(numbers[i])){
                int j = map.get(numbers[i]);
                if(i > j){
                    ans[0] = j+1;
                    ans[1] = i+1;
                }else{
                    ans[0] = i+1;
                    ans[1] = j+1;
                }
                break;
            }
        }
        return ans;
    }
}
