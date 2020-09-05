package zy.leetcode.backtracking.solution60;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    private int cnt = 0;
    private int k;
    private int n;
    private boolean[] visited;
    private String ans = "";
    public String getPermutation(int n, int k) {
        this.k = k;
        this.n = n;
        visited = new boolean[n];
        doBacktracking("");
        return ans;
    }

    private void doBacktracking(String path){
        if(cnt == k){
            return;
        }
        if(path.length() == n){
            cnt ++;
            if(cnt == k) ans = path;
            return;
        }
        for(int i = 1; i <= n; i++){
            if(!visited[i-1]){
                visited[i-1] = true;
                path = path + String.valueOf(i);
                doBacktracking(path);
                path = path.substring(0,path.length()-1);
                visited[i-1] = false;
            }
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals("213", sol.getPermutation(3, 3));
    }
}
