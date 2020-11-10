package zy.leetcode.dp.solution264;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Boolean> map;
    public int nthUglyNumber(int n) {
        map = new HashMap<>();
        map.put(1, true);
        map.put(2, true);
        map.put(3, true);
        map.put(5, true);
        int ans = 1;
        int i = 1;
        while(true){
            if(isUgly(i)){
                ans = i;
                n--;
                if(n==0) break;
            }
            i++;
        }
        return ans;
    }

    private boolean isUgly(int n){
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n%2==0){
            boolean rel = isUgly(n/2);
            map.put(n, rel);
            return rel;
        }

        if(n%3==0){
            boolean rel = isUgly(n/3);
            map.put(n, rel);
            return rel;
        }

        if(n%5==0){
            boolean rel = isUgly(n/5);
            map.put(n, rel);
            return rel;
        }
        return false;
    }
}
