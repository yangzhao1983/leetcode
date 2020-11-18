package zy.leetcode.array.solution134sec;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumG = 0;
        int sumC = 0;
        int n = gas.length;
        for(int i = 0; i < n; i++){
            sumG += gas[i];
            sumC += cost[i];
        }
        if(sumG < sumC){
            return -1;
        }
        int start = -1;
        int acc = 0;
        for(int i =0; i < n; i++){
            acc += gas[i] - cost[i];
            if(acc < 0) {
                start = i;
                acc = 0;
            }
        }
        return start + 1;
    }
}
