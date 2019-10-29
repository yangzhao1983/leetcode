package zy.leetcode;

/**
 * Created by kaiser_zhao on 2018/10/16.
 */
public class Solution9 {
    /**
     *
     * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

     Example 1:

     Input: 121
     Output: true
     Example 2:

     Input: -121
     Output: false
     Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     Example 3:

     Input: 10
     Output: false
     Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     Follow up:

     Could you solve it without converting the integer to a string?

     2147483647
     -2147483648
     */

    /**
     * 1. 0
     *
     * 2. <0
     *
     * 3. 121
     *
     * 4. 10
     *
     * 5. 2147483647 false
     *
     * 6. 2147 44 7412  true
     *
     * 7. 123321 true
     *
     * 8. 123
     *
     *
     * if x < 0 return false
     * if 0<=x <=9 return true
     *
     * tmp = number
     * target = 0
     * if tmp = 0, break
     * else
     *  left = tmp % 10
     *  target = target * 10 + left
     *  tmp = tmp/10
     *  if target = tmp return true
     *  if target >tmp return false
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else if(x<10){
            return true;
        }else if (x%10==0){
            return false;
        }else{
            int tmp = x;
            int target = 0;
            int left = 0;
            while(true){
                left = tmp % 10;
                target = target * 10 + left;
                if(target == tmp){
                    return true;
                }else if (target > tmp){
                    return false;
                }

                tmp = tmp/10;
                if(target == tmp){
                    return true;
                }else if (target > tmp){
                    return false;
                }
            }
        }
    }
    public final static void main(String...strings){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(-100));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(12));
        System.out.println(isPalindrome(110));
        System.out.println(isPalindrome(2147483647));
        System.out.println(isPalindrome(2147447412));
        System.out.println(isPalindrome(123321));
        System.out.println(isPalindrome(123));
    }
}

