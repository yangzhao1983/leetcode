package zy.leetcode.sortandsearch.solution1122;

import java.util.*;

public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> numPos = new HashMap<>();
        for(int i = 0; i < arr2.length; i++){
            numPos.put(arr2[i], i);
        }
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0 ; i < arr1.length; i++){
            list1.add(arr1[i]);
        }
        Collections.sort(list1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(numPos.containsKey(o1) && numPos.containsKey(o2)){
                    return numPos.get(o1) - numPos.get(o2);
                }else if(numPos.containsKey(o1)){
                    return -1;
                }else if(numPos.containsKey(o2)){
                    return 1;
                }else{
                    return o1 - o2;
                }
            }
        });
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = list1.get(i);
        }
        return arr1;
    }
}
