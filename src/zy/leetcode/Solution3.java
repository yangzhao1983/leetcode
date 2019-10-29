package zy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaiser_zhao on 25/09/2018.
 *
 * traverse s from index 0, current index is start, max = 0
 *  1. index = start,
 *  2. traverse s from start, current index is end, end = start + 1
 *      2.1 if map.contains(s[end]), max = end-start, break, start = map.get(s[end]) + 1,
 *      2.2 else put s[start] to map, key = s[start], value = start end = end + 1
 *      2.3 if end = length, clear map.
 */
public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int maxLen = 0;
        Map<Character, Integer> mapCtoIndex = new HashMap<Character, Integer>();
        for(int i = 0; i<len;){
            mapCtoIndex.clear();
            int start = i;
            mapCtoIndex.put(cs[start], start);
            int end=start+1;
            for(; end<len; end++){
                if(mapCtoIndex.containsKey(cs[end])){
                    i = mapCtoIndex.get(cs[end]) + 1;
                    break;
                }else{
                    mapCtoIndex.put(cs[end],end);
                }
            }
            int newMaxLen = end - start;
            if(newMaxLen>maxLen){
                maxLen = newMaxLen;

                if(maxLen >= (len-i)){
                    break;
                }
            }

            if(end == cs.length){
                break;
            }
        }
        return maxLen;
    }

    public final static void main(String...strings){
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring2(s));
    }

    /**
     * Created by kaiser_zhao on 25/09/2018.
     *
     * Given a string, find the length of the longest substring without repeating characters.
     * 0. Initialize max length $maxLen to 0
     * 1. get the length of the string as $len
     * 2. loop from 0 to len-2 as $start
     *  2.1 for each $start
     *      2.1.-1 create map, key is character, value is the index of the character as $cIndexMap
     *      2.2.0 put {$s[$start], $start} to $cIndexMap
     *      2.1.1 loop from $start+1 to len-1 as $end
     *          2.1.1.1 IF $cIndexMap contains key $s[end]
     *              2.1.1.1.1 IF $maxLen < $end-$start
     *                  2.1.1.1.1.1 $maxLen = $end-$start
     *                  2.1.1.1.1.2 $start should be the index after $s[$end]
     *                  2.1.1.1.1.3 remove $s[$start~$end] from $cIndexMap
     *                  2.1.1.1.1.4 break
     *      2.1.2 IF $end is equal to $len
     *          2.1.2.1 IF $maxLen < $end-$start
     *              2.1.2.1.1 $maxLen = $end-$start
     *          2.1.2.2 break
     *      2.1.3 the number of items left in s is $len-$start, as $leftLen
     *      2.1.4 IF $maxLen >= $leftLen
     *          2.1.4.1 break
     *
     *
     */

    /**
     * Given a string, find the length of the longest substring without repeating characters ($maxLength).
     *
     * First, define window sliding, often used for dealing with array
     * 1. given A, length = $len, indices from 0 to $len-1
     * 2. window is a[i,j) where 0<=i<j<$len
     * 3. Sliding means i and j can "move" from left to right.
     *
     * Second, define sub function, to verify if there is duplicated item for a[j] in a[i,j).
     * 1. If yes, then j++, find a[k] = a[j], i = k+1.
     * 2. If no, j++
     * 3. update $maxLength.
     */
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
