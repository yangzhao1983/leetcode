package zy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kaiser_zhao on 15/06/2019.
 */
public class Solution76 {

    // slide window
    private static String minWindow(String s, String t){
        int left = 0;
        int right = 0;
        String rel = "";

        while(left < s.length() && right < s.length()){
            if(compareSet(s, left, right, t)){
                if(right-left +1 >rel.length()){
                    rel = s.substring(left, right+1);
                }
                left++;
            }else{
                right++;
            }
        }
        return rel;
    }

    // array -> set,
    private static boolean compareSet(String ss, int left, int right, String t){

        Set<Character> subStringSet = stringToSet(ss, left, right);
        Set<Character> tSet = stringToSet(t, 0, t.length());

        return subStringSet.containsAll(tSet);
    }

    /**
     * Convert string[left:right] to set, so that we can compare the two sets to check if the substring
     * contains T.
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private static Set<Character> stringToSet(String s, int left, int right){
        Set<Character> set = new HashSet<>();

        return set;
    }
}
