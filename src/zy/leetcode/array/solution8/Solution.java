package zy.leetcode.array.solution8;

public class Solution {
    /**
     * find the first non-space char, if not [1-9]|+|-, return 0
     * if -1 sign = -1
     * ans = 0
     * if [1-9], ans = ans * 10 + num
     * if ans = max or ans=min or ans=max/10, num > 7 or ans=min/10, num < -8 return max/min
     *
     */
    public int myAtoi(String str) {
        int ans = 0;
        int i = 0;
        if(str.length() == 0){
            return 0;
        }

        while(i <str.length() && str.charAt(i)==' '){
            i++;
        }
        int sign = 1;
        if(i == str.length()){
            return ans;
        }else if(str.charAt(i)=='-'){
            sign = -1;
            i++;
        }else if (str.charAt(i)=='+'){
            sign = 1;
            i++;
        }

        while(i<str.length()){
            char curChar = str.charAt(i++);
            if(curChar>='0' && curChar<='9'){
                int curNum = curChar - '0';
                if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && curNum >7)){
                    return Integer.MAX_VALUE;
                }else if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && curNum >8)){
                    return Integer.MIN_VALUE;
                }else{
                    ans = ans*10 + sign * curNum;
                }
            } else{
                break;
            }
        }
        return ans;
    }

    private static void test1(){
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("42"));
    }


    private static void test2(){
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("     -42"));
    }

    private static void test3(){
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("4193 with words"));
    }

    private static void test4(){
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("words and 987"));
    }

    private static void test5(){
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("-91283472332"));
    }

    private static void test6(){
        Solution sol = new Solution();
        System.out.println(sol.myAtoi(""));
    }

    private static void test7(){
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("    0000000000000   "));
    }

    private static void test8(){
        Solution sol = new Solution();
        System.out.println(sol.myAtoi(" "));
    }

    private static void test9(){
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("   +0 123"));
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
    }
}
