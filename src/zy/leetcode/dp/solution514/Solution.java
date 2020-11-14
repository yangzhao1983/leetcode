package zy.leetcode.dp.solution514;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    /**
     * every char in ring, r is a node
     * len from ri to rj
     * key is the path from k[0] to k[m]
     * shortest path from k[0] to k[m]
     * <p>
     * tree:
     * r[i]->r[j], 0<=j<n
     * r[j]==k[l]
     * there may be more than one option
     * dfs: should have a way to mark which path has been tried. source + target
     *
     * @param ring
     * @param key
     * @return
     */
    private int[][] memo;
    private String ring;
    private int m;
    private int n;
    private String key;
    private Map<Character, List<Integer>> map;


    public int findRotateSteps(String ring, String key) {
        this.ring = ring;
        this.key = key;
        this.m = ring.length();
        this.n = key.length();
        memo = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                memo[i][j] = Integer.MAX_VALUE;
            }
        }
        map = new HashMap<>();
        for(int i = 0; i < m; i++){
            map.computeIfAbsent(ring.charAt(i), x->new ArrayList<>()).add(i);
        }
        doDFS(0, 0);
        return Arrays.stream(memo[0]).min().getAsInt();
    }

    private int doDFS(int posR, int posK){
        if(posK == n){
            return 0;
        }
        if(memo[posK][posR] < Integer.MAX_VALUE){
            return memo[posK][posR];
        }
        int min = Integer.MAX_VALUE;
        for(int i : map.get(key.charAt(posK))){
            int absStep = Math.abs(i - posR);
            int step = Math.min(absStep, m - absStep);
            min = Math.min(step + 1 + doDFS(i, posK+1), min);
        }
        memo[posK][posR] = min;
        return min;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals(4, sol.findRotateSteps("godding"
                ,"gd"));
    }
}
