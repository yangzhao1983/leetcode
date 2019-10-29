package zy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiser_zhao on 17/06/2019.
 */
public class P1 {

    public static void main(String...strings){
        System.out.println(solution("Sat", 1));
        System.out.println(solution("Sat", 2));
        System.out.println(solution("Sat", 9));
    }

    public static String solution(String S, int K) {
        // write your code in Java SE 8
        List<String> dOW = new ArrayList<>() ;
        dOW.add("Mon");
        dOW.add("Tue");
        dOW.add("Wed");
        dOW.add("Thu");
        dOW.add("Fri");
        dOW.add("Sat");
        dOW.add("Sun");
        int indexOfS = dOW.indexOf(S);

        int leftOfKMod7 = K%7;
        int relIndex = (leftOfKMod7 + indexOfS)%7;
        return dOW.get(relIndex);
    }
}
