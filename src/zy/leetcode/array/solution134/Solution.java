package zy.leetcode.array.solution134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        for(int i = 0; i < n; i++){
            int acc = 0;
            int step = 0;
            for(; step < n; step++){
                int cur = (i + step)%n;
                acc += gas[cur] - cost[cur];
                if(acc <0) break;
            }
            if(step == n) return i;
        }
        return -1;
    }
}
