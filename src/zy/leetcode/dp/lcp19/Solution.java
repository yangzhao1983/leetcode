package zy.leetcode.dp.lcp19;

public class Solution {
    public int minimumOperations(String leaves) {
        int dp0 = isRed(leaves.charAt(0));
        int dp1 = Integer.MAX_VALUE-1;
        int dp2 = Integer.MAX_VALUE-1;
        for(int i = 1; i < leaves.length();i++){
            char cur = leaves.charAt(i);
            int oldDp0 = dp0;
            dp0 = dp0 + isRed(cur);
            int oldDp1 = dp1;
            dp1 = Math.min(oldDp0 + isYellow(cur), dp1 + isYellow(cur));
            if(i==1) dp2 = Integer.MAX_VALUE-1;
            else dp2 = Math.min(oldDp1 + isRed(cur), dp2 + isRed(cur));
        }
        return dp2;
    }
    private int isRed(char c){
        if(c=='r') return 0;
        else return 1;
    }
    private int isYellow(char c){
        if(c=='y') return 0;
        else return 1;
    }
}
