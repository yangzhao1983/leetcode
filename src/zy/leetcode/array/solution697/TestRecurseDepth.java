package zy.leetcode.array.solution697;

/**
 * Created by kaiser_zhao on 2019/9/3.
 */
public class TestRecurseDepth {

    public static void main(String...strings){
        //recurse(1<<14);
        //recurse(22673);
        System.out.println(Integer.MAX_VALUE);
    }

    private static void recurse(int input){
        if (input == 0){
            return;
        }else{
            recurse(input - 1);
        }
    }
}
