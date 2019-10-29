package zy.leetcode;

/**
 * Created by kaiser_zhao on 2018/10/3.
 */
public class Solution5 {

    public final static void main(String... strings){
        String s1 = "babadada";
        String s2 = "a";
        String s3 = "aa";
        String s4 = "ab";
        String s5 = "abb";
        String s6 = "aba";
        String s7 = "abab";
        String s8 = "ssssabba";
        String s9 = "ccc";
        String s10 = "scscccc";
//        System.out.println(longestPalindrome3(s1));
//        System.out.println(longestPalindrome3(s2));
//        System.out.println(longestPalindrome3(s3));
//        System.out.println(longestPalindrome3(s4));
//        System.out.println(longestPalindrome3(s5));
//        System.out.println(longestPalindrome3(s6));
 //       System.out.println(longestPalindrome3(s7));
 //      System.out.println(longestPalindrome3(s8));
//        System.out.println(longestPalindrome3(s9));
        System.out.println(longestPalindrome3(s10));
    }

    /**
     * reverse s, got s'
     * for every substring of s, sb
     * 1. sb in s
     * 2. sb in s', sb'
     * 3. index of sb' in s = index of sb in s
     *
     * @param s
     * @return
     */
    public static String longestPalindrome3(String s) {
        String max = s.substring(0,1);
        char[] cReverse = new char[s.length()];
        for(int i = 0; i <s.length();i++){
            cReverse[s.length()-i-1] = s.charAt(i);
        }
        String sReverse = String.copyValueOf(cReverse);
        for(int i = 0; i<s.length()-1;i++){
            for(int j = i+1; j<=s.length();j++){
                String seq = s.substring(i,j);
                if((j-i)<=max.length()){
                    continue;
                }
                if(sReverse.contains(seq)){
                    int index = 0;
                    while(true){
                        index = sReverse.indexOf(seq, index);
                        if(index<0){
                            break;
                        }else{
                            if(index == s.length() - j){
                                max = seq;
                            }
                            index++;
                        }
                    }
                }
            }
        }
        return max;
    }

    /**
     * A[0]^,A[1]^,..^A[start],^A[start+1],..A[mid1],A[mid2]...A[end-1], A[end],..A[l-1]
     * A[0],A[1],..A[start],A[start+1],..A[mid1],...A[end-1], A[end],..A[l-1]
     *
     * max
     *
     * given mid, 0<=cur<l-2
     *  A[cur] = A[cur+1], mid1 = cur, mid2 = cur+1 compare A[mid1-i], A[mid2+i]
     * given mid,  0<=cur<l-2
     *  A[cur] != A[cur+1], mid = cur, compare A[mid-i], A[mid+i]
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if(s.length()<=1){
            return s;
        }
        String max = s.substring(0,1);
        int end = s.length() * 2-1;
        int start = 0;
        for(int i = 0; i<end; i++){
            if(i%2==0){
                // number cur= i/2
                int cur = i/2;
                int j = 1;
                for(; j<= Math.min(cur, s.length()-1-cur);j++){
                    if(s.charAt(cur-j) != s.charAt(cur+j)){
                       break;
                    }
                }
                if(j>1){
                    int len = (j-1) * 2 +1;
                    int curStart = cur-j+1;
                    int curEnd = len + curStart;
                    if(len > max.length()){
                        max = s.substring(curStart, curEnd);
                    }
                }
            }else{
                int cur1 = i/2;
                int cur2 = i/2 + 1;
                if(s.charAt(cur1)!=s.charAt(cur2)){
                    continue;
                }
                int j = 1;
                for(; j<= Math.min(cur1, s.length()-1-cur2);j++){
                    if(s.charAt(cur1-j) != s.charAt(cur2+j)){
                        break;
                    }
                }

                int len = (j-1) * 2 +2;
                int curStart = cur1-j+1;
                int curEnd = len + curStart;
                if(len > max.length()){
                    max = s.substring(curStart, curEnd);
                }

            }
        }
        return max;
    }
    public static String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        String max = s.substring(0,1);
        for(int cur = 0; cur <= s.length()-2; cur++){
            if(s.charAt(cur) == s.charAt(cur+1)){
                int i = 1;
                for(; i<=Math.min(cur,  s.length() - cur-2); i++){
                    if(s.charAt(cur-i)!=s.charAt(cur+1+i)){
                        break;
                    }
                }


                    int start = cur-i+1;
                    int len =  2*i;
                    int end = start + len;
                    if(len>max.length()){
                        max = s.substring(start, end);
                    }

            }else{
                int i = 1;
                boolean got = false;
                for (; i <=Math.min(cur, s.length()- cur-1);i++){
                    if(s.charAt(cur-i)!=s.charAt(cur+i)){
                        break;
                    }else{
                        got = true;
                    }
                }
                if(got){
                    int start = cur-i + 1;
                    int len = 2*i-1;
                    int end = start + len;
                    if(len>max.length()){
                        max = s.substring(start, end);
                    }
                }
            }
        }
        return max;
    }
}
