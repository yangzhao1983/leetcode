package zy.agr;

/**
 * Created by kaiser_zhao on 29/07/2019.
 */
public class NumberOfOne {

    public static void main(String...strings){
        int target = 19;
        System.out.println(Integer.toBinaryString(target));
        System.out.println(Integer.toOctalString(target));
        System.out.println(getNumOfOne(target));
    }

    private static int getNumOfOne(int target){
        int countOfOne = 0;
        while(target > 0){
            countOfOne++;
            target = target & (target - 1);
        }
        return countOfOne;
    }
}
