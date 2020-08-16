package zy.leetcode.tree.solution733;

import org.junit.Test;

public class Solution {
    private int oldColor;
    private int[][] image;
    private int newColor;
    private int m;
    private int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor) return image;
        this.image = image;
        this.newColor = newColor;
        this.oldColor = image[sr][sc];
        this.m = image.length;
        this.n = image[0].length;
        doDFS(sr, sc);
        return this.image;
    }

    private void doDFS(int r, int c){
        if(image[r][c] != oldColor){
            return;
        }

        image[r][c] = newColor;

        if(r > 0) doDFS(r-1, c);

        if(r < m-1) doDFS(r+1, c);

        if(c >0) doDFS(r, c-1);

        if(c<n-1) doDFS(r, c+1);
    }

    @Test
    public void test1(){
        int[][] images = {{0,0,0},{0,1,1}};
        int sc = 1;
        int sr = 1;
        int newColor = 1;
        Solution sol = new Solution();
        sol.floodFill(images, sc, sr,newColor);
        System.out.println();
    }
}
