package zy.leetcode.twopointers.solution75sec;

public class Solution {
    public void sortColors(int[] nums) {
        // l, r
        // if lb = '0', lb moves forward.
        // if lb = '1', lf moves forward.
        // if lb = '2', stop
        // if lf = '1', lf moves forward
        // if lf = '0', swap lb and lf, lb moves forward
        // if lf = '2', stop
        // if rf = '0',
        //      if lb = '2', swap lb and rf, rf move backward, lb move forward.
        //      if lf = '2', swap lf an rf, rf move backward, swap lb and lf, move lb, move lf
        // if rf = '2', rf moves backward
        // if rf = '1',
        //      if lb = '2', swap lb and rf, rf move backward, lb move forward.
        //      if lf = '2', swap lf an rf, rf move backward, swap lb and lf, move lb, move lf
        if(nums == null || nums.length <=1) return;
        int lb = 0;
        int lf = 0;
        int n = nums.length;
        int r = n - 1;
        while(lf < r){
            while(lb < r && nums[lb] == 0) lb++;
            if(lf < lb)lf = lb;
            while(lb < r && nums[lf] == 1) lf++;
            if(lb < r && nums[lf] == 0){
                swap(nums, lf, lb);
                continue;
            }
            // lf = '2'
            while(r>lf && nums[r] == 2) r--;
            if(r > lf){
                swap(nums, lf, r);
                if(nums[lf] == 0){
                    if(lf != lb) swap(nums, lf, lb);
                }
            }
        }
    }

    private void swap(int[] nums, int src, int tgt){
        int tmp = nums[src];
        nums[src] = nums[tgt];
        nums[tgt] = tmp;
    }
}
