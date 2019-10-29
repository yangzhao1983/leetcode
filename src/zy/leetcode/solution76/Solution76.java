package zy.leetcode.solution76;

import java.util.*;

/**
 * Created by kaiser_zhao on 05/08/2019.
 */
public class Solution76 {
    public static void main(String...s){

        System.out.println(minWindow("AABCAC","AB"));
        System.out.println(minWindow("AABCAC","C"));
        System.out.println(minWindow("","C"));
        System.out.println(minWindow("AABCAC","BC"));
    }

    public static String minWindow(String s, String t) {

        if(t==null || t.isEmpty() || s == null || s.isEmpty()){
            return "";
        }

        // If there is only one char in t.
        if(t.length()==1){
            return s.contains(t) ? t : "";
        }

        Map<Character, Integer> foundChars = new LinkedHashMap<>();
        Set<Character> unmatchedSet = new HashSet<Character>();

        // add chars from t to unmatched. Order can be ignored.
        for(Character c : t.toCharArray()){
            unmatchedSet.add(c);
        }

        int start = -1;
        int len = Integer.MAX_VALUE;
        char[] chars = s.toCharArray();
        String rel = "";

        for(int i = 0; i< chars.length; i++){

            // if char[i] in s can be found in t
            if(unmatchedSet.contains(chars[i])){
                unmatchedSet.remove(chars[i]);

                // first match
                if(start == -1){
                    start = i;
                }

                // put the matched char[i] into map{char[i], i}
                // here the order is important, since we need to know the start index of the matched substring.
                // so use linked hash map
                foundChars.put(chars[i], i);

                // all of the chars in t has been matched, in other words, we get the window in s.
                if(unmatchedSet.isEmpty()) {

                    // calculate the length of the window, if it is the shortest one by now, record it.
                    int tempLen = i - start + 1;
                    if (len > tempLen) {
                        len = tempLen;
                        rel = s.substring(start, i + 1);
                    }

                    // Here need to remove the first char in the window, and put it back to the unmatched set.
                    char firstChar = foundChars.keySet().iterator().next();
                    foundChars.remove(firstChar);
                    unmatchedSet.add(firstChar);

                    // We need to do another round of match, but we don't need to start from start+1.
                    // Instead, the start from the second matched char in s.
                    start = foundChars.get(foundChars.keySet().iterator().next());
                }
            }

            if(foundChars.containsKey(chars[i])){
                // If hit a chars[i] which is already in found chars, update the index.
                foundChars.remove(chars[i]);
                foundChars.put(chars[i], i);

                // Need to update start if the duplicated char reside in chars[start]
                if(chars[start] == chars[i]){
                    start = foundChars.get(foundChars.keySet().iterator().next());
                }
            }
        }

        return rel;
    }
}
