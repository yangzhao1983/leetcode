package zy.leetcode.agr1.dp.solution70;

/**
 * Created by kaiser_zhao on 2019/9/18.
 */
public class ResolvedByDP {

    public static void main(String...strings){
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {

        if(n <=2 ){
            return n;
        }

        int[] counts = new int[n+1];
        counts[0] = 0;
        counts[1] = 1;
        counts[2] = 2;

        for(int i = 3; i <= n; i++){
            counts[i] = counts[i-1] + counts[i-2];
        }

        return counts[n];
    }
}
