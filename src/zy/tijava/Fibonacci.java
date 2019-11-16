package zy.tijava;

/**
 * Created by kaiser_zhao on 2019/3/25.
 */
public class Fibonacci {
    public static void main(String...strings){
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
    }

    private static int fibonacci(int num){
        int first = 1;
        int second = 1;
        int rel = 1;

        if(num >= 3 ){
            for(int i = 3; i <= num; i++){
                rel = first + second;
                first = second;
                second = rel;
            }
        }

        return second;
    }
}
