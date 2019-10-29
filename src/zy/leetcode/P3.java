package zy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiser_zhao on 17/06/2019.
 */
public class P3 {

    public static void main(String...strings){
//        System.out.println(solution(0));
//        System.out.println(solution(1));
//        System.out.println(solution(2));
//        System.out.println(solution(3));
//        System.out.println(solution(8));
//        System.out.println(solution(36));
        System.out.println(solution(147483647));
    }

    public static int solution(int N) {
        // write your code in Java SE 8
        List<Integer> rel = new ArrayList<>();
        rel.add(0);
        rel.add(1);
        for(int i= 2; i <= N; i++){
            rel.add((rel.get(i-1) + rel.get(i-2))%1000000);
        }
        return rel.get(N);
    }
}
