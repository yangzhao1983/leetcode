package zy.leetcode.array.solution119;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // 1
    // 1,1
    // 1,2,1
    // 1,3,3,1
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int[] a = new int[rowIndex + 1];
        a[0] = 1;
        if(rowIndex>=1) {
            a[1] = 1;
            if (rowIndex > 1) {
                a[1] = 1;
                for (int i = 2; i <= rowIndex; i++) {
                    int lastLeft = 1;
                    for (int j = 1; j < i; j++) {
                        int lastCur = a[j];
                        int cur = lastLeft + lastCur;
                        lastLeft = lastCur;
                        a[j] = cur;
                    }
                    a[i] = 1;
                }
            }
        }
        for(int i = 0; i < rowIndex+1; i++){
            ans.add(a[i]);
        }
        return ans;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        List<Integer> a = sol.getRow(4);
        System.out.println();
    }
}
