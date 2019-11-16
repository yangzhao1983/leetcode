package zy.tijava;

import java.util.Arrays;

/**
 * Created by kaiser_zhao on 2019/3/25.
 *
 * https://www.cnblogs.com/JohnTsai/p/4103051.html
 *
 * Thinking in Java 4th Edition Annotated Solutions Guide
 */
public class VampireNumber {
    public static void main(String...strings){
        findVampireNumber2();
    }

    private static void findVampireNumber(){
        // Num[1000,9801]
        // If num%100 == 0, no
        // Transit num to A, B, C, D A*1000 + B *100 + C * 10 + D = num
        // If find B==0, or C==0, no
        // If D = 0, try AB * CD, BA * CD, AC * BD, CA * BD,AD * BC, AD * CB
        // try AB * CD, AB * DC, BA * CD, BA * DC, AC * BD, AC * DB, CA * BD, CA * DB, AD * BC, AD * CB, DA * BC, DA * CB
        //
    }

    /**
     * Thinking in java
     *
     * Pete Hartley's theoretical result:
     * If x·y is a vampire number then
     * x·y == x+y (mod 9)
     *
     */
    private static void findVampireNumber2(){

        String[] arrCan = null;
        String[] arrMul = null;

        for(int first = 11; first < 99; first++){
            for(int second = first + 1; second < 100; second++){
                int can = first * second;
                if(can % 100 == 0 || can <1000 || can > 10000){
                    continue;
                }

                if(can %9 == (first + second)%9){
                    String strMul = Integer.toString(first) + Integer.toString(second);
                    String strCan = Integer.toString(can);
                    arrMul = strMul.split("");
                    Arrays.sort(arrMul);
                    arrCan = strCan.split("");
                    Arrays.sort(arrCan);
                    if(Arrays.equals(arrMul, arrCan)){
                        System.out.println(can);
                    }
                }
            }
        }
    }
}
