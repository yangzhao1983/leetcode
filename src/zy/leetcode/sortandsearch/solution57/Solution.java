package zy.leetcode.sortandsearch.solution57;

import org.junit.Test;
import sun.jvm.hotspot.memory.Space;
import sun.tools.jstat.Literal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 1. find first ai from intervals where ai[0] >= newInterval[0]
     * 2. merge newInterval, ai, ai+1...
     * 3. create new arrays: intervals[0, i-1] + left combined with newInterval
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals==null || intervals.length == 0){
            int[][] singleAns = new int[1][2];
            singleAns[0][0] = newInterval[0];
            singleAns[0][1] = newInterval[1];
            return singleAns;
        }

        int start = 0;
        while(start < intervals.length && intervals[start][0] < newInterval[0]){
            start ++;
        }

        int [] base = null;
        start --;
        List<List<Integer>> merged = new ArrayList<>();
        if(start ==-1){
            base = newInterval;
        }else{
            base = merge(intervals[start], newInterval,merged);
        }

        for(int i = start + 1; i < intervals.length; i++){
            base = merge(base, intervals[i], merged);
        }

        int[][] ans = new int[(start >0? start: 0) + merged.size() + 1][2];

        for(int i = 0; i< start;i++){
            ans[i][0] = intervals[i][0];
            ans[i][1] = intervals[i][1];
        }

        int relStart = Math.max(start, 0);
        for(int i = 0; i < merged.size();i++){
            ans[relStart+ i][0] = merged.get(i).get(0);
            ans[relStart + i][1] = merged.get(i).get(1);
        }

        ans[ans.length-1][0] = base[0];
        ans[ans.length-1][1] = base[1];

        return ans;
    }

    private int[] merge(int[] left, int[] right, List<List<Integer>> merged){
        if(left[1] < right[0]){
            List<Integer> list = new ArrayList<>();
            list.add(left[0]);
            list.add(left[1]);
            merged.add(list);
            return right;
        }else if(left[1] < right[1]){
            return new int[]{left[0], right[1]};
        }else{
            return left;
        }
    }

    @Test
    public void test(){
        Solution sol = new Solution();
        int[][] ans =sol.insert(new int[][] {{1,3},{6,9}}, new int[]{2,5});
        System.out.println();
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        int[][] ans =sol.insert(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        System.out.println();
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        int[][] ans =sol.insert(new int[][] {{1,5}}, new int[]{2,3});
        System.out.println();
    }
}
