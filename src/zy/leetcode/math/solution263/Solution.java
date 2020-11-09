package zy.leetcode.math.solution263;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Boolean> map;
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        map = new HashMap<>();
        map.put(0, Boolean.TRUE);
        map.put(1, Boolean.TRUE);
        map.put(2, Boolean.TRUE);
        map.put(3, Boolean.TRUE);
        map.put(4, Boolean.TRUE);
        map.put(5, Boolean.TRUE);
        return check(num);
    }

    private boolean check(int num){
        if(map.containsKey(num)){
            return map.get(num);
        }
        if(num%2==0){
            boolean rel = check(num/2);
            map.put(num, rel);
            return rel;
        }
        if(num%3==0){
            boolean rel = check(num/3);
            map.put(num, rel);
            return rel;
        }
        if(num%5==0){
            boolean rel = check(num/5);
            map.put(num, rel);
            return rel;
        }
        map.put(num ,false);
        return false;
    }
}
