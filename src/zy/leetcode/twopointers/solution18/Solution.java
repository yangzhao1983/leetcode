package zy.leetcode.twopointers.solution18;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer,List<Integer>> combination = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length<4){
            return ans;
        }

        Arrays.sort(nums);

        for(int i = 0; i< nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            for(int j = i+1; j<nums.length-2; j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }

                int L = j+1;
                int R = nums.length - 1;

                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] +nums[R];

                    if(sum == target){
                        ans.add(Arrays.asList(nums[i], nums[j],nums[L],nums[R]));

                        // remove duplicated
                        while(L < R && nums[L]==nums[L+1]){
                            L++;
                        }
                        while(L < R && nums[R]==nums[R-1]){
                            R--;
                        }
                        L++;
                        R--;
                    }else if(sum > target){
                        R--;
                    }else{
                        L++;
                    }
                }

            }
        }

        return ans;
    }

    private static void test1(){
        Solution sol = new Solution();
        List<List<Integer>> list = sol.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);

        for(List<Integer> l : list){
            for(int i : l){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void test2(){
        Solution sol = new Solution();
        List<List<Integer>> list = sol.fourSum(new int[]{0,0,0,0}, 0);

        for(List<Integer> l : list){
            for(int i : l){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void test3(){
        Solution sol = new Solution();
        List<List<Integer>> list = sol.fourSum(new int[]{-1,0,1,2,-1,-4}, -1);

        for(List<Integer> l : list){
            for(int i : l){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
    }
}
