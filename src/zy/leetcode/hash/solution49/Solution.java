package zy.leetcode.hash.solution49;

import org.junit.Test;

import java.util.*;

public class Solution {
    private final static int ALPHABET = 26;
    private int[] stat = new int[ALPHABET];
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            String encoded = encodeStr(str);
            map.computeIfAbsent(encoded, k->new ArrayList<>()).add(str);
        }
        for(String key : map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }

    private String encodeStr(String str){
        String encoded = "";

        for(int i = 0; i< str.length();i++){
            stat[str.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < ALPHABET;i++){
            encoded += "#";
            encoded += stat[i];
        }

        Arrays.fill(stat, 0);
        return encoded;
    }

    @Test
    public void test1() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution sol = new Solution();
        List<List<String>> list = sol.groupAnagrams(strs);
        System.out.println();
    }
}
