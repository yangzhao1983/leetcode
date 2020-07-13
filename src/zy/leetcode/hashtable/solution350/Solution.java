package zy.leetcode.hashtable.solution350;

import java.util.*;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0 || nums2 == null || nums2.length==0) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num)){
                int cnt = map.get(num);
                if(cnt > 0){
                    ans.add(num);
                    map.put(num, cnt-1);
                }
            }
        }

        int[] ansA = new int[ans.size()];
        for(int i = 0 ; i < ans.size();i++){
            ansA[i] = ans.get(i);
        }
        return ansA;
    }
}
