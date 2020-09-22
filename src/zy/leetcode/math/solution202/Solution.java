package zy.leetcode.math.solution202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        if(n==1) return true;

        Set<Integer> visited = new HashSet<>();

        visited.add(n);
        while(n != 1){
            int sum = 0;
            while(n > 0){
                int mod = n%10;
                sum += mod * mod;
                n /= 10;
            }
            n = sum;
            if(visited.contains(n)) return false;
            else visited.add(n);
        }
        return true;
    }
}
