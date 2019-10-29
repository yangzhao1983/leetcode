package zy.leetcode;

/**
 * Created by kaiser_zhao on 2018/10/11.
 */
public class Solution8 {
    /**
     * Implement atoi which converts a string to an integer.
     *
     * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
     * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as
     * possible, and interprets them as a numerical value.
     *
     * The string can contain additional characters after those that form the integral number,
     * which are ignored and have no effect on the behavior of this function.
     *
     * If the first sequence of non-whitespace characters in str is not a valid integral number,
     * or if no such sequence exists because either str is empty or it contains only whitespace characters,
     * no conversion is performed.
     *
     * If no valid conversion could be performed, a zero value is returned.
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if(str.length()==0){
            return 0;
        }
        // 1. if str.length == 0, return 0;
        // 2. get the first char not "empty". Empty means eqaul to ' '. If can not find it, return 0.
        // 3.1 If first char not in [-, +, 0 ~ 9], return 0.
        // 3.2 If equal to [0~9], number = char go to 4#
        // 3.2 If equal to [-,+], go to 4#
        // 4. go through the chars after it, until hit char not in [0~9], return the number
        //    char--->int
        //    if number >0,
        //         if number=Integer.MAX_VALUE/10 and char>7, return Integer.MAX_VALUE
        //         if number >Integer.MAX_VALUE/10, return Integer.MAX_VALUE
        //    if number <0,
        //         if number <Integer.MIN_VALUE/10, return Integer.MIN_VALUE
        //         if number=Integer.MIN_VALUE/10 and char<-8, return Integer.MIN_VALUE
        //    number = number X 10 + char
        int number = 0;
        int mul = 1;
        boolean start = false;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)==' '){
                if (start){
                    break;
                }
            }else if (str.charAt(i)=='-' || str.charAt(i)=='+'){
                if(start){
                    break;
                }else{
                    start = true;
                    mul = str.charAt(i)=='+'? 1 : -1;
                }
            } else if (str.charAt(i)>='0' && str.charAt(i)<='9'){
                if(!start){
                    start = true;
                }
                int charInt = str.charAt(i) - '0';
                if(mul>0){
                    if(number == Integer.MAX_VALUE/10 && charInt>7){
                        return Integer.MAX_VALUE;
                    }else if (number>Integer.MAX_VALUE/10){
                        return Integer.MAX_VALUE;
                    }else{
                        number = number * 10 + charInt;
                    }
                }else{
                    if(number * -1 == Integer.MIN_VALUE/10 && charInt>8){
                        return Integer.MIN_VALUE;
                    }else if (number * -1 < Integer.MIN_VALUE/10){
                        return Integer.MIN_VALUE;
                    }else{
                        number = number * 10 + charInt;
                    }
                }
            } else{
                break;
            }

        }

        return mul>0 ? number : -1 * number;
    }

    public final static void main(String...strings){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
//        System.out.println(myAtoi("   1"));
//        System.out.println(myAtoi("   -1"));
//        System.out.println(myAtoi("   +1"));
//        System.out.println(myAtoi("   -12"));
//        System.out.println(myAtoi("   +13"));
//        System.out.println(myAtoi("   adfa123"));
//        System.out.println(myAtoi("   2147483647"));
//        System.out.println(myAtoi("   2147483648"));
//        System.out.println(myAtoi("   -2147483648"));
//        System.out.println(myAtoi("   -2147483649"));
//        System.out.println(myAtoi("   -21474 83649"));
        System.out.println(myAtoi("-5-"));
    }
}
