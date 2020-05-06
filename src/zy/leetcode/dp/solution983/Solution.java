package zy.leetcode.dp.solution983;

import org.junit.Assert;
import org.junit.Test;
import sun.awt.geom.AreaOp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * dp[i] = min{costs[j] + dp[i+j]}
     *
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int[] ans = new int[367];
        ans[ans.length - 1] = 0;
        Set<Integer> setDays = new HashSet<>();

        for(int day : days){
            setDays.add(day);
        }

        ans[366] = 0;
        for(int i = ans.length-2; i >=1; i--){
            ans[i] = minCosts(setDays,costs, ans,i);
        }

        return ans[1];
    }

    private int minCosts(Set days, int[] costs, int[] memo, int i){
        if(!days.contains(i)){
            return memo[i+1];
        }else{
            int min = Integer.MAX_VALUE;
            if(i + 1 < memo.length && (memo[i+1] + costs[0])< min){
                min = memo[i+1] + costs[0];
            }
            if(i + 7 < memo.length && (memo[i+7] + costs[1])< min){
                min = memo[i+7] + costs[1];
            }
            if(i + 30 < memo.length && (memo[i+30] + costs[2])< min){
                min = memo[i+30] + costs[2];
            }
            return min;
        }
    }

    @Test
    public void test1(){
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        Solution sol = new Solution();
        Assert.assertEquals(11, sol.mincostTickets(days, costs));
    }

    @Test
    public void test2(){
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2,7,15};
        Solution sol = new Solution();
        Assert.assertEquals(17, sol.mincostTickets(days, costs));
    }

    @Test
    public void test3(){
        int[] days = {1,4,6,7,8,365};
        int[] costs = {2,7,15};
        Solution sol = new Solution();
        Assert.assertEquals(11, sol.mincostTickets(days, costs));
    }
}
