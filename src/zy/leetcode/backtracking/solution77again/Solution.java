package zy.leetcode.backtracking.solution77again;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private int k;
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        doBacktracking(n, 0, new ArrayList<>());
        return ans;
    }

    private void doBacktracking(int n, int cur, List<Integer> single){
        if(single.size() == k ){
            List<Integer> item = new ArrayList<>();
            item.addAll(single);
            ans.add(item);
            return;
        }

        for(int i = cur+1; i <=n; i++){
            single.add(i);
            doBacktracking(n, i, single);
            single.remove(single.size()-1);
        }
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        List<List<Integer>> list = sol.combine(4,2);
        System.out.println();
    }
}

