package zy.leetcode.array.solution1024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int videoStitching(int[][] clips, int T) {
        // map, left time -> List<Integer> right time
        // clips[i], check from cur to clips[i][1]/T, max(clips[j][1])
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < clips.length; i++){
            map.computeIfAbsent(clips[i][0], x->new ArrayList<>()).add(clips[i][1]);
        }

        int cnt = 1;
        int start = 0;
        int end = 0;

        while(true){
            int max = end;
            for(int j = start; j <= end; j++){
                if(map.containsKey(j)){
                    for(int k : map.get(j)){
                        if(k > max) max = k;
                    }
                }
            }
            if(max >= T){
                break;
            }else if(max== end){
                return -1;
            }else{
                cnt++;
                start ++;
                end = max;
            }
        }
        return cnt;
    }
}
