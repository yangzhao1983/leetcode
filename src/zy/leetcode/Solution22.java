package zy.leetcode;

import java.util.*;

/**
 * Created by kaiser_zhao on 2018/10/29.
 */
public class Solution22 {

    public static void main(String...strings){
//        System.out.println(generateParenthesis(0));
//        System.out.println(generateParenthesis(1));
//        System.out.println(generateParenthesis(2));
//        System.out.println(generateParenthesis(3));

    }

    public static List<String> generateParenthesis(int n) {
        List<String> rel = new ArrayList<>();
        if(n==0){
            return rel;
        }
        Set<String> relSet = doGenerateParenthesis(n);
        rel = new ArrayList<>(relSet);
        return rel;
    }

    private static Set<String> cover(Set<String> rel){
        Set<String> newRel = new HashSet<>();
        if(rel.size()==0){
            newRel.add("()");
        }else{
            for(String val : rel){
                newRel.add("(" + val + ")");
            }
        }
        return newRel;
    }

    private static Map<Integer, Set<String>> tmpRel = new HashMap<Integer, Set<String>>();

    private static Set<String> doGenerateParenthesis(int n){
        if(tmpRel.containsKey(n)){
            return tmpRel.get(n);
        }

        Set<String> rel = new HashSet<>();

        if (n==1){
            rel.add("()");
        }else {
            // 0. get (n-1)
            Set<String> minus = doGenerateParenthesis(n-1);

            // 1. cover
            rel = cover(minus);

            // 2. left, and right
            for(String cur : minus){
                rel.add("()" + cur);
                rel.add(cur + "()");
            }

            // if n >=4
            // 2, n/2 left, right
            if(n>=4){
                for(int i = 2; i<=n/2;i++){
                    Set<String> minus1 = doGenerateParenthesis(i);
                    Set<String> minus2 = doGenerateParenthesis(n-i);
                    for(String cur1 : minus1){
                        for(String cur2 : minus2){
                            rel.add(cur1+cur2);
                            rel.add(cur2+cur1);
                        }
                    }
                }
            }
        }

        tmpRel.put(n, rel);

        return rel;
    }
}
