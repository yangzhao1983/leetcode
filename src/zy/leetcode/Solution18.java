package zy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kaiser_zhao on 2018/10/27.
 */
public class Solution18
{
    public static void main(String...strings){
        //System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        // System.out.println(fourSum(new int[]{-7,-5,0,7,1,1,-10,-2,7,7,-2,-6,0,-10,-5,7,-8,5}, 28));

//        System.out.println(fourSum(new int[]{0,0,0,0}, 0));
        System.out.println(fourSum(new int[]{-1,-5,-5,-3,2,5,0,4}, -7));

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rel4 = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        if(nums.length < 4){
            return rel4;
        }
        for(int i = 0; i<nums.length-3;i++){
            if(i > 0){
                if(nums[i]==nums[i-1]){
                    continue;
                }
            }

            merge(rel4, nums[i], threeSum(nums, i+1, target - nums[i]));

        }
        return rel4;
    }

    private static void merge(List<List<Integer>> rel4, int i, List<ArrayList<Integer>> rel3){
        if(rel3.size()==0){
            return;
        }

        for(ArrayList<Integer> rel : rel3 ){
            rel.add(i);
            rel4.add(rel);
        }
    }

    private static List<ArrayList<Integer>> threeSum(int[] nums, int start, int target){
        List<ArrayList<Integer>> rel3 = new ArrayList<ArrayList<Integer>>();
        for(int i = start; i < nums.length-2;i++){
            // if i>0, skip i
            if(i != start && nums[i]==nums[i-1]){
                continue;
            }

            // left = target - nums[i]
            // j == i + 1;
            // k == nums.length - 1
            // while(j<k)
            // if nums[j] + nums[k] == left, add it, skip j, k
            //                      <        j++     skip j
            //                      >        k--     skip k
            int left = target - nums[i];
            int j = i + 1;
            int k = nums.length -1;
            while(j<k){
                if(nums[j] + nums[k] == left){

                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    rel3.add(list);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]){j++;}
                    while(j<k && nums[k]==nums[k+1]){k--;}
                }else if (nums[j] + nums[k] > left){
                    k--;
                    while(j<k && nums[k]==nums[k+1]){k--;}
                }else{
                    j++;
                    while(j<k && nums[j]==nums[j-1]){j++;}
                }
            }
        }

        return rel3;
    }
}
