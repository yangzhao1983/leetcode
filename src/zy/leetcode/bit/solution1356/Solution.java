package zy.leetcode.bit.solution1356;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[] sortByBits(int[] arr) {
        int[] bit = new int[10001];

        for(int i = 1; i < bit.length; i++){
            bit[i] = bit[i>>1] + (i & 1);
        }

        List<Integer> list = new ArrayList<>();
        for(int a : arr){
            list.add(a);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(bit[o1]== bit[o2]){
                    return o1 - o2;
                }else{
                    return bit[o1] - bit[o2];
                }
            }
        });

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
