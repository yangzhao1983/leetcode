package zy.leetcode.hash.solution771;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J == null || S==null) return 0;
        Set<Character> jewels = new HashSet<>();
        int cnt = 0;
        for(int i = 0; i < J.length(); i++){
            jewels.add(J.charAt(i));
        }
        for(int i = 0; i < S.length(); i++){
            if(jewels.contains(S.charAt(i))) cnt++;
        }

        return cnt;
    }
}
