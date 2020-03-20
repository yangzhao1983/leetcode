package zy.leetcode.dp.solution10;

public class Solution {
    /**
     * s[i]
     * p[j]
     *
     * match[s.len+1][p.len+1]
     * match[0][0] = true
     *
     * if i>0 && j>0, s[i]==p[j] || p[j]==., then match[i][j] == match[i-1][j-1]
     * if j>1, p[j-1]=., p[j]=*, match[i][j] = match[i][j-2] || match[i-1][j-2] || ..
     * if j>1, p[j-1]!=., p[j]=*, match[i][j] = match[i][j-2] || match[i-1][j-2] || .. where s[i] == p[j-1]
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        boolean[][] match = new boolean[s.length()+1][p.length()+1];

        for(int i=0; i<s.length()+1;i++){
            for(int j = 0; j<p.length()+1;j++){
                if(i== 0 && j==0){
                    match[i][j] = true;
                }else{
                    if(i>0 && j>0 && (s.charAt(i-1)==p.charAt(j-1)
                            || p.charAt(j-1) == '.' )){
                        match[i][j] = match[i-1][j-1];
                    }else if(j>1 && p.charAt(j-2)=='.' && p.charAt(j-1)=='*'){
                        for(int cur = i; cur>=0;cur--){
                            if(match[cur][j-2]){
                                match[i][j] = true;
                                break;
                            }
                        }
                    }else if(j>1 && p.charAt(j-2)!='.' && p.charAt(j-1)=='*'){
                        int cur = i;
                        do{
                            if(match[cur][j-2]){
                                match[i][j] = true;
                                break;
                            }
                            cur--;
                        }while(cur >=0 && s.charAt(cur) == p.charAt(j-2));
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }

    private static void test1(){
        Solution sol = new Solution();
        System.out.println(sol.isMatch("aa","a"));
    }
    private static void test2(){
        Solution sol = new Solution();
        System.out.println(sol.isMatch("aa","a*"));
    }
    private static void test3(){
        Solution sol = new Solution();
        System.out.println(sol.isMatch("ab",".*"));
    }
    private static void test4(){
        Solution sol = new Solution();
        System.out.println(sol.isMatch("aab","c*a*b"));
    }
    private static void test5(){
        Solution sol = new Solution();
        System.out.println(sol.isMatch("mississippi","mis*is*p*."));
    }
    private static void test6(){
        Solution sol = new Solution();
        System.out.println(sol.isMatch("a","ab*"));
    }
    public static void main(String...strings){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
}
