package zy.leetcode.dp.solution70;

import javax.swing.plaf.SliderUI;

public class Solution {
    public int climbStairs(int n) {
        if (n==0){
            return 0;
        }
        int[] methodNum = new int[n+1];
        methodNum[0] = 1;
        methodNum[1] = 1;
        for(int i = 2; i<=n;i++){
            methodNum[i] = methodNum[i-2] + methodNum[i-1];
        }
        return methodNum[n];
    }

    private static void test(){
        System.out.println(new Solution().climbStairs(4));
    }

    public static void main(String...strings){
        test();
    }
}
