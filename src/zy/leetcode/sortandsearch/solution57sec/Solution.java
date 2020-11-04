package zy.leetcode.sortandsearch.solution57sec;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * loop X,
     * if Xi_l > S'_r, add S to A, add Xi...Xe to A.
     * if Xi_l <= S'_l, Xi_r >= S'_l or Xi_l<=S'_r, Xi_r >= S'_r, merge Xi and S', get S'
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) return intervals;
        if (intervals == null || intervals.length == 0) {
            int[][] ans = new int[1][2];
            ans[0][0] = newInterval[0];
            ans[0][1] = newInterval[1];
            return ans;
        }
        List<List<Integer>> list = new ArrayList<>();

        int nl = newInterval[0];
        int nr = newInterval[1];

        boolean inserted = false;
        int i = 0;
        for (; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (l > nr) {
                if (!inserted) {
                    List<Integer> single = new ArrayList<>();
                    single.add(nl);
                    single.add(nr);
                    list.add(single);
                    inserted = true;
                }
                List<Integer> single = new ArrayList<>();
                single.add(l);
                single.add(r);
                list.add(single);
            } else if (r < nl) {
                List<Integer> single = new ArrayList<>();
                single.add(l);
                single.add(r);
                list.add(single);
            } else {
                nl = Math.min(nl, l);
                nr = Math.max(nr, r);
            }
        }

        if (!inserted) {
            List<Integer> single = new ArrayList<>();
            single.add(nl);
            single.add(nr);
            list.add(single);
        }

        int[][] ans = new int[list.size()][2];

        int j = 0;
        for (; j < list.size(); j++) {
            ans[j][0] = list.get(j).get(0);
            ans[j][1] = list.get(j).get(1);
        }

        return ans;
    }
}
