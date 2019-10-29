package zy.leetcode;

/**
 * Created by kaiser_zhao on 2018/10/16.
 */
public class Solution10 {
    /**
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

     '.' Matches any single character.
     '*' Matches zero or more of the preceding element.
     The matching should cover the entire input string (not partial).

     Note:

     s could be empty and contains only lowercase letters a-z.
     p could be empty and contains only lowercase letters a-z, and characters like . or *.

     * p:
     * *,
     *
     */
    public static void main(String...strings){
        System.out.println(match2("a","a")==true);
        System.out.println(match2("a","a*")==true);
        System.out.println(match("a","*")==false);
        System.out.println(match2("","")==true);
        System.out.println(match2("","a")==false);

        System.out.println(match2("","bb")==false);
        System.out.println(match2("",".")==false);
        System.out.println(match2("",".*")==true);
        System.out.println(match2("","aaa")==false);
        System.out.println(match2("","a*")==true);
        System.out.println(match2("a","a*")==true);
        System.out.println(match2("a","")==false);
        System.out.println(match2("a","a*")==true);
        System.out.println(match2("aac","a*c")==true);
        System.out.println(match2("aac","*")==false);
        System.out.println(match2("aac",".*c")==true);
        System.out.println(match2("aac",".*.")==true);
        System.out.println(match2("ab",".*")==true);
        System.out.println(match2("","c*c*")==true);
        System.out.println(match2("bbab","b*a*")==false);
        System.out.println(match2("bbbab","b*bab")==true);
        System.out.println(match2("","**")==false);
        System.out.println(isMatch("","**")==false);
    }

    public static boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    private static boolean match(String s, String p){
        return doMatch(0,0,s,p);
    }
    private static boolean match2(String s, String p){
        return doMatch2(0,0,s,p);
    }

    private static boolean doMatch2(int sStart, int pStart, String s, String p) {
        if (sStart == s.length()) {
            if (pStart == p.length()) {
                return true;
            } else if (pStart == p.length() - 1) {
                return false;
            } else if (pStart == p.length() - 2) {
                if (p.charAt(pStart) != '*' && p.charAt(pStart + 1) == '*') {
                    return true;
                } else {
                    return false;
                }
            } else if (pStart < p.length() - 2 && p.charAt(pStart ) != '*' && p.charAt(pStart + 1) == '*') {
                pStart += 2;
                return doMatch2(sStart, pStart, s, p);
            } else{
                return false;
            }
        } else {
            if (pStart == p.length()) {
                return false;
            } else {
                if (s.charAt(sStart) == p.charAt(pStart)) {
                    if (pStart < p.length() - 1 && p.charAt(pStart + 1) == '*') {

                        int k = sStart + 1;
                        for (; k < s.length(); k++) {
                            if (s.charAt(k) != s.charAt(sStart)) {
                                break;
                            }
                        }
                        pStart += 2;
                        for (int m = sStart; m <= k; m++) {
                            if (doMatch2(m, pStart, s, p)) {
                                return true;
                            }
                        }
                        return false;
                    } else {
                        return doMatch2(++sStart, ++pStart, s, p);
                    }
                } else {
                    if (p.charAt(pStart) == '.') {
                        if (pStart + 1 < p.length() && p.charAt(pStart + 1) == '*') {
                            pStart += 2;
                            for (; sStart < s.length(); sStart++) {
                                if (doMatch2(sStart, pStart, s, p)) {
                                    return true;
                                }
                            }
                            return doMatch2(sStart, pStart, s, p);
                        } else {
                            return doMatch2(++sStart, ++pStart, s, p);
                        }
                    } else if (p.charAt(pStart) == '*') {
                        return false;
                    } else {
                        if (pStart + 1 < p.length() && p.charAt(pStart + 1) == '*') {
                            pStart = pStart + 2;
                            return doMatch2(sStart, pStart, s, p);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
    }

    private static boolean doMatch(int sStart, int pStart, String s, String p){
        while(sStart< s.length() && pStart < p.length()) {
            if (s.charAt(sStart) == p.charAt(pStart)) {
                sStart++;
                pStart++;
            } else if (p.charAt(pStart) == '.') {
                sStart++;
                pStart++;
            } else if (p.charAt(pStart) == '*') {
                if (pStart == 0) {
                    return false;
                } else if (p.charAt(pStart - 1) == '*') {
                    return false;
                } else if (p.charAt(pStart - 1) != '.') {
                    for (int i = sStart; i < s.length() && p.charAt(i) == p.charAt(sStart - 1); i++) {
                        if (doMatch(i, pStart, s, p)) {
                            return true;
                        }
                    }
                } else {
                    for (int i = sStart; i < s.length(); i++) {
                        if (doMatch(i, pStart, s, p)) {
                            return true;
                        }
                    }
                }
            }


        if(sStart == s.length() && pStart == p.length()){
            return true;
        }else{
            return false;
        }
    }
    return false;
    }

}
