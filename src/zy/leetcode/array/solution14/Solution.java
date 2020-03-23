package zy.leetcode.array.solution14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {

        if(strs==null || strs.length == 0){
            return "";
        }

        if(strs[0]==null || strs[0].length()==0){
            return "";
        }

        boolean end = false;
        int i = 0;
        for(; i<strs[0].length(); i++){
            for(int j = 1; j<strs.length;j++){
                if(i >= strs[j].length() || strs[j].charAt(i)!= strs[0].charAt(i)){
                    end = true;
                    break;
                }
            }
            if(end){
                break;
            }
        }
        return strs[0].substring(0, i);
    }

    private static void test1(){
        Solution sol = new Solution();
        String[] strs = {"1",""};
        System.out.println(sol.longestCommonPrefix(strs));
    }

    private static void test2(){
        String[] strs = {"1"};
        Solution sol = new Solution();
        System.out.println(sol.longestCommonPrefix(strs));
    }

    private static void test3(){
        String[] strs = {"ab","abc"};
        Solution sol = new Solution();
        System.out.println(sol.longestCommonPrefix(strs));
    }

    private static void test4(){
        String[] strs = {"abc","ab"};
        Solution sol = new Solution();
        System.out.println(sol.longestCommonPrefix(strs));
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
        test4();
    }
}
