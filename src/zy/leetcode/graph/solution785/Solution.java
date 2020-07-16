package zy.leetcode.graph.solution785;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    int[] dfs = null;
    int[][] graph =null;
    boolean ans = true;
    public boolean isBipartite(int[][] graph) {
        // dfs[i]=0, never visited
        // dfs[i]=1, red
        // dfs[i]=2, green
        if(graph==null || graph.length == 0) return true;
        dfs = new int[graph.length];
        this.graph=graph;
        for(int i = 0; i < graph.length; i++){
            if(dfs[i]==0) doDFS(i, 1);
        }

        return ans;
    }

    private void doDFS(int start, int color){
        if(!ans) return;

        // check whether point i is valid
        if(dfs[start] > 0){
            if(dfs[start] == color) ans = false;
            return;
        }else{
            dfs[start] = color == 1? 2:1;
        }

        for(int i = 0; i < graph[start].length; i++){
            doDFS(graph[start][i], dfs[start]);
        }
    }

    @Test
    public void test1(){
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isBipartite(graph));
    }

    @Test
    public void test2(){
        int[][] graph = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.isBipartite(graph));
    }
}
