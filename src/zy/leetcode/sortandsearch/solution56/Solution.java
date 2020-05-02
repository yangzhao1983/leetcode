package zy.leetcode.sortandsearch.solution56;

import org.junit.Test;
import zy.leetcode.linked.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    List<List<Integer>> ansList = new ArrayList<>();
    /**
     * assuming only merge two array, a,b
     * a[0] <= b[0]
     * case1: a[1] < b[0], => a, b
     * case2: a[1] >= b[0] && a[1] < b[1], => a'
     * case3: a[1] >= b[1], => a
     *
     * first sort the intervals
     * then merge from first to last
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[0][2];
        }
//        sort(intervals);
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] base = intervals[0];
        for(int i = 1; i < intervals.length ; i++){
            base = mergeTwo(base, intervals[i]);
        }
        int[][] ans = new int[ansList.size() + 1][2];
        for(int i = 0; i < ansList.size();i++){
            ans[i][0] = ansList.get(i).get(0);
            ans[i][1] = ansList.get(i).get(1);
        }
        ans[ans.length-1][0] = base[0];
        ans[ans.length-1][1] = base[1];

        return ans;
    }

    private void sort(int[][] intervals){
        int from = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < intervals.length-1; i++){
            int j = 0;
            for(; j < intervals.length-i; j++){
                if(intervals[j][0] > max){
                    from = j;
                }
            }
            if(j!= intervals.length - i){
                swap(from, intervals.length-i, intervals);
            }
        }
    }

    private void swap(int src, int tgt, int[][] nums){
        int tmp1 = nums[src][0];
        int tmp2 = nums[src][1];

        nums[src][0] = nums[tgt][0];
        nums[src][1] = nums[tgt][1];

        nums[tgt][0] = tmp1;
        nums[tgt][1] = tmp2;
    }

    /**
     *      assuming only merge two array, a,b
     *      a[0] <= b[0]
     *      case1: a[1] < b[0], => a, b
     *      case2: a[1] >= b[0] && a[1] < b[1], => a'
     *      case3: a[1] >= b[1], => a
     * @param first
     * @param second
     * @return
     */
    private int[] mergeTwo(int[] first, int [] second){
        if(first[1] < second[0]){
            List<Integer> item = new ArrayList<>();
            item.add(first[0]);
            item.add(first[1]);
            ansList.add(item);
            return second;
        }else if(first[1] >= second[0] && first[1] < second[1]){
            int[] newFirst = {first[0], second[1]};
            return newFirst;
        }else{
            return first;
        }
    }

    @Test
    public void test1(){
        int[][] intervals = new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        };
        Solution sol = new Solution();
        int[][] ans = sol.merge(intervals);
        System.out.println();
    }
}
