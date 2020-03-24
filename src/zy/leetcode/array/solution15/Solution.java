package zy.leetcode.array.solution15;

import java.util.*;

public class Solution {
    /**
     * find map<integer, Set<Integer>>
     *
     * find n = map.key, and not in set
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null || nums.length < 3){
            return ans;
        }

        Arrays.sort(nums);

        for(int i = 0; i<nums.length-2; i++){
            if(nums[i]>0){
                break;
            }

            if(i > 0 && nums[i]==nums[i-1]){
                continue;
            }
            int first = i;
            int second = i+1;
            int third = nums.length-1;
            while(second < third){
                int sum = nums[first] + nums[second] + nums[third];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    while(second < third && nums[second]==nums[second+1]){
                        second ++;
                    }
                    while(second < third && nums[third]==nums[third-1]){
                        third--;
                    }
                    second++;
                    third--;
                }else if (sum < 0){
                    second ++;
                }else if (sum > 0){
                    third--;
                }
            }
        }
        return ans;
    }

    private static void outPutList(List<List<Integer>> ans){
        for(List<Integer> list : ans){
            for(int i : list){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    private static void test1(){

        Solution sol = new Solution();
        outPutList(sol.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static void main(String...strings){
        test1();
    }
}
