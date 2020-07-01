package zy.leetcode.array.solution718;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int findLength(int[] A, int[] B) {
        int[] l, s;
        if(A.length > B.length){
            l = A;
            s = B;
        }else{
            l = B;
            s = A;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < l.length; i++){
            map.computeIfAbsent(l[i], x->new ArrayList<>()).add(i);
        }

        int ans = 0;
        int len = 0;
        for(int i = 0; i < s.length; i++){
            if(map.containsKey(s[i])){
                for(Integer pos : map.get(s[i])){
                    len = 0;
                    int k = i;
                    int m = pos;
                    while(k < s.length && m < l.length && s[k++]==l[m++]) len ++;
                    if(len > ans) ans = len;
                }
            }
        }
        return ans;
    }

    @Test
    public void test1(){
        int[] A= {1,2,3,2,1};
        int[] B=  {3,2,1,4,7};
        Solution sol = new Solution();
        Assert.assertEquals(3, sol.findLength(A, B));
    }
}
