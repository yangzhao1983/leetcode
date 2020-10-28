package zy.leetcode.hash.solution1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        Set<Integer> cnts = new HashSet<>(map.values());
        return cnts.size() == map.size();
    }
}
