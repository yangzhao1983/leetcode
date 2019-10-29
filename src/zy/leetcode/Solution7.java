package zy.leetcode;

/**
 * Created by kaiser_zhao on 2018/10/11.
 */
public class Solution7 {

    public final static void main(String...strings){
//        System.out.println(reverse(100));
//        System.out.println(reverse(1));
//        System.out.println(reverse(123));
//        System.out.println(reverse(1534236469));
//        System.out.println(reverse(-1563847412));
        System.out.println(reverse(1463847412));
//        System.out.println(reverse(-2147483412));
    }
    public static int inverseInt(int x) {
        long target = 0;
        int plus = 1;
        if(x<0){
            plus = -1;
            x = -1 * x;
        }
        while(x > 0){
            int left = x%10;
            target = target * 10 + left;
            x = x/10;
        }
        long minVal = Integer.MIN_VALUE;
        if(plus>0 && target> Integer.MAX_VALUE){
            return 0;
        }else if(plus<0 && (target-1) > (-1 * minVal)){
            return 0;
        }else{
            return (int)target * plus;
        }
    }
    public static int inverseInt2(int x) {
        long target = 0;

        while(Math.abs(x) > 0){
            int left = x%10;
            target = target * 10 + left;
            x = x/10;
        }
        if(target > Integer.MAX_VALUE || target < Integer.MIN_VALUE){
            return 0;
        }
        return (int)target;
    }

    public static int reverse(int x) {
        long target = 0;

        // x= -2147483412
        //-2147483648
        //
        while(Math.abs(x) > 0){
            if(target > Integer.MAX_VALUE/10 || target  < Integer.MIN_VALUE/10){
                System.out.println(target);
                System.out.println(Integer.MAX_VALUE/10);
                return 0;
            }
            int left = x%10;
            target = target * 10 + left;
            x = x/10;
        }

        return (int)target;
    }

    public static int reverse2(int x) {
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > INT_MAX/10 || (rev == INT_MAX / 10 && pop > 7)) return 0;
            if (rev < INT_MIN/10 || (rev == INT_MIN / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
