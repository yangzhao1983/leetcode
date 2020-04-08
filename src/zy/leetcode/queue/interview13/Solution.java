package zy.leetcode.queue.interview13;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class Solution {
    private int count = 0;
    private boolean[][] invalid;
    private LinkedList<Integer> q = new LinkedList<>();
    private int k = 0;
    private int m;
    private int n;
    /**
     * a[m][n], if visited continue
     * if not accessible, continue
     * count++
     *
     * add a[m][n] top/bottom/left/right to queue
     *
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        invalid = new boolean[m][n];
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!invalid[i][j]){
                    dfs(i,j);
                    if(count > max){
                        max = count;
                    }
                }
                count = 0;
            }
        }
        return max;
    }

    private void dfs(int hor, int ver){
        if(invalid[hor][ver]){
            return;
        }

        invalid[hor][ver] =true;

        int val = getVal(hor,ver);
        if(val > k){
            return;
        }
        count++;

        // left
        if(ver > 0){
            dfs(hor, ver - 1);
        }

        // right
        if(ver < n-1){
            dfs(hor, ver + 1);
        }

        // top
        if(hor > 0){
            dfs(hor-1, ver);
        }

        // down
        if(hor < m-1){
            dfs(hor+1, ver);
        }
    }

    private int getVal(int m, int n){
        int val = 0;
        while(m > 0){
            val += m%10;
            m = m/10;
        }
        while(n > 0){
            val += n%10;
            n = n/10;
        }
        return val;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(3, sol.movingCount(2,3,1));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.movingCount(3,1,0));
    }
}
