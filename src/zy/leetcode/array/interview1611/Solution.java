package zy.leetcode.array.interview1611;

public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        int[] ans;
        if(k==0){
            ans =new int[0];
            return ans;
        }
        if(shorter == longer){
            ans = new int[1];
            ans[0] = k * shorter;
        }else{
            ans = new int[k+1];
            ans[0] = shorter * k;
            int diff = longer - shorter;
            for(int i = 1; i < ans.length;i++){
                ans[i] = ans[i-1] + diff;
            }
        }
        return ans;
    }
}
