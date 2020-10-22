package zy.leetcode.twopointers.solution763;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * 1. set = {}
     * 2. S[i], if there it is not in set, put it to set with its pos, [i,i]; S[i]-> scan[i,i]
     *          else, S[i] -> scan[old_start, i], for each c in [old_start, old_end], update scan[]
     *
     * 3. S[0], get scan[start_0, end_0], end_0+1...
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {

        List<Integer> ans = new ArrayList<>();
        Map<Character, Pair<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            char c= S.charAt(i);
            if(map.containsKey(c)){
                int oldStart = map.get(c).getKey();
                for(int j = oldStart;j<=i; j++){
                    map.put(S.charAt(j), new Pair<>(oldStart, i));
                }
            }else{
                map.put(S.charAt(i), new Pair<>(i, i));
            }
        }
        int start = 0;
        while(start < S.length()){
            int end = map.get(S.charAt(start)).getValue();
            ans.add(end  - start + 1);
            start = end+1;
        }
        return ans;
    }
}
