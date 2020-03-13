package zy.leetcode.dp.solution5;

public class Solution {
    /**
     *
     * boolean p[][], where p[i][j] == true Si...Sj is palindrome.
     * obviously, p[i][i] is palindrome,
     * if p[i][j] is palindrome, p[i-1][j+1] is palindrome if s[i-1] == s[j+1]
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s==null || s.length() ==0){
            return "";
        }

        boolean[][] p = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length();i++){
            p[i][i] = true;

        }
        String ans = s.substring(0,1);
        for(int i = 1; i <= s.length()-1; i++){ // length of the scan

            for(int j = 0; j<s.length() - i; j++){ // start point
                if(i==1){
                    p[j][j+i] = s.charAt(j) == s.charAt(j+1);
                }else{
                    p[j][j+i] = p[j+1][j+i-1] && s.charAt(j) == s.charAt(j+i);
                }
                if(p[j][j+i]){
                    ans = s.substring(j, j+i+1);
                }
            }
        }
        return ans;
    }

    private static void test1(){
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("babad"));
    }

    private static void test2(){
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("cbbd"));
    }

    private static void test3(){
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("c"));
    }

    private static void test4(){
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("aaaa"));
    }

    private static void test5(){
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("cbbd"));
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}
