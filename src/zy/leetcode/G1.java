package zy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kaiser_zhao on 14/06/2019.
 */
public class G1 {
    public static void main(String...strings){

        /**
         * if(nums == null || nums.length == 0 || nums.length ==1){
         */
        int[] nums = null;
        System.out.println(twoSum(nums, 4));
        nums = new int[0];
        System.out.println(twoSum(nums, 4));
        nums = new int[1];
        nums[0] = 1;
        System.out.println(twoSum(nums, 4));

        // existing first numbers, whose_value + current_value = target
        // put second_value:index to map
        nums = new int[4];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        printAll(twoSum(nums, 4));

        // put second_value:index to map
        // current_value > target/2, end.
        nums = new int[4];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 8;
        nums[3] = 9;
        printAll(twoSum(nums, 7));

        // existing first numbers, whose_value + current_value = target ===>twice
        // put second_value:index to map
        nums = new int[4];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        printAll(twoSum(nums, 5));

        // existing first numbers, whose_value + current_value = target
        // put second_value:index to map, first_value=second_value
        nums = new int[4];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        nums[3] = 4;
        printAll(twoSum(nums, 4));

        // existing first numbers, whose_value + current_value = target
        // put second_value:index to map, duplicated first
        nums = new int[5];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        nums[3] = 3;
        printAll(twoSum(nums, 5));

        // existing first numbers, whose_value + current_value = target
        // put second_value:index to map, duplicated second
        nums = new int[5];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 3;
        printAll(twoSum(nums, 5));
    }

    public static List<int[]> twoSum(int[] nums, int target){

        System.out.println("+++++++++++++++++++++");

        List<int[]> list = new ArrayList<>();

        // length < 2
        if(nums == null || nums.length == 0 || nums.length ==1){
            return list;
        }

        Map<Integer, List<Integer>> results = new HashMap<>();

        for(int i = 0; i<nums.length;i++){
            // existing first numbers, whose_value + current_value = target
            if(results.keySet().contains(nums[i])){
                for(int first : results.get(nums[i])){
                    int[] rel = new int[2];
                    rel[0] = first;
                    rel[1] = i;
                    list.add(rel);
                }
            }
            // no existing first numbers, whose_value + current_value = target
            else{
                // current_value > target/2, end.
                if(nums[i] > target/2){
                    break;
                }else{
                    // put second_value:index to map
                    results.computeIfAbsent(target-nums[i],x->{return new ArrayList<>();}).add(i);
                }
            }
        }

        return list;
    }

    private static void printAll(List<int[]> list){
        for(int[] rel : list){
            System.out.println("==========");
            System.out.println("first = " + rel[0]);
            System.out.println("second = " + rel[1]);
        }
    }
}
