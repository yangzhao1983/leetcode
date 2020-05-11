package zy.leetcode.twopointers.solution76;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<String, Integer> strCounts = new HashMap<>();
        LinkedList<Integer> window = new LinkedList<>();
        Map<String, Integer> skippedCounts = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        int back = 0;
        int minBack = 0;
        int forward = 0;
        int sum = 0;

        for(int i = 0; i < t.length(); i++){
            String single = t.substring(i,i+1);
            strCounts.put(single, strCounts.getOrDefault(single, 0)+1);
            sum++;
        }

        // starting pos
        while(back < s.length() && !strCounts.containsKey(s.substring(back, back+1))){
            back++;
        }

        if(back == s.length()){
            return "";
        }else{
            forward = back;
        }

        while(back < s.length() && forward < s.length()){

            String cur = s.substring(forward, forward+1);
            if(strCounts.containsKey(cur)){
                // t contains cur
                if(strCounts.get(cur) > 0){
                    window.addLast(forward);
                    strCounts.put(cur, strCounts.get(cur)-1);
                    sum--;
                    // all chars in t can be found in s
                    if(sum==0){
                        int len = window.getLast() - window.getFirst() + 1;
                        if (len < ans) {
                            ans = len;
                            minBack = back;
                            System.out.println(s.substring(minBack, minBack + ans));
                            System.out.println();
                        }
                        if(len==1){
                            break;
                        }

                        // move back and forward
                        String first = s.substring(window.getFirst(), window.getFirst()+1);
                        strCounts.put(first, strCounts.get(first) + 1);
                        window.removeFirst();
                        String next = s.substring(window.getFirst(), window.getFirst() + 1);
                        while(window.size() > 0 && skippedCounts.getOrDefault(next, 0) > 0){
                            window.removeFirst();
                            skippedCounts.put(next, skippedCounts.get(next)-1);
                            next = s.substring(window.getFirst(), window.getFirst() + 1);
                        }
                        back = window.getFirst();
                        sum++;
                    }
                }else{
                    // abca, duplicated char is the first char
                    // abcc, the duplicated char is just before cur char
                    // abcb, else duplicated situation
                    if(s.substring(window.getFirst(), window.getFirst()+1).equals(cur)){
                        window.removeFirst();
                        if(window.size() > 0 ){
                            String next = s.substring(window.getFirst(), window.getFirst() + 1);
                            while(window.size() > 0 && skippedCounts.getOrDefault(next, 0) > 0){
                                window.removeFirst();
                                skippedCounts.put(next, skippedCounts.get(next)-1);
                                next = s.substring(window.getFirst(), window.getFirst() + 1);
                            }
                        }
                        window.addLast(forward);

                        back = window.getFirst();
                    }
                    else{
                        // TODO: minus?
                        skippedCounts.put(cur, skippedCounts.getOrDefault(cur, 0) + 1);
                        window.addLast(forward);
                    }
                }
            }
            forward++;
        }

        return ans > s.length()? "" : s.substring(minBack, minBack + ans);
    }

    @Test
    public void test1(){
        String s = "ADOBECODEBANC";
        String t= "ABC";
        Solution sol = new Solution();
        Assert.assertEquals("BANC", sol.minWindow(s, t));
    }

    @Test
    public void test2(){
        String s = "a";
        String t= "a";
        Solution sol = new Solution();
        Assert.assertEquals("a", sol.minWindow(s, t));
    }

    @Test
    public void test3(){
        String s = "bba";
        String t= "ab";

        Solution sol = new Solution();
        Assert.assertEquals("ba", sol.minWindow(s, t));
    }

    @Test
    public void test4(){
        String s = "adobecodebancbbcaa";
        String t= "abc";

        Solution sol = new Solution();
        Assert.assertEquals("bca", sol.minWindow(s, t));
    }

    @Test
    public void test5(){
        String s = "ask_not_what_your_country_can_do_for_you_ask_what_you_can_do_for_your_country";
        String t=  "ask_country";

        Solution sol = new Solution();
        Assert.assertEquals("sk_not_what_your_c", sol.minWindow(s, t));
    }

    @Test
    public void test6(){
        String s = "cbabcabba";
        String t=  "acab";

        Solution sol = new Solution();
        Assert.assertEquals("abca", sol.minWindow(s, t));
    }

    @Test
    public void test7(){
        // acaab acaba bcbca cbbcc bacca aacac abbbc accab ccabb ca
        // bacab abcbc acbbc cbacc aaaca cabb
        // babcb cacbb ccbac caaac acabb b"
        String s = "acaabacababcbcacbbccbaccaaacacabbbcaccabccabbca";
        String t=  "bbaacbacbbccbcaabbacbacac";

        Solution sol = new Solution();
        Assert.assertEquals("babcbcacbbccbaccaaacacabbb", sol.minWindow(s, t));
    }
}
