package zy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kaiser_zhao on 2018/10/26.
 */
public class Solution17 {

    public static void main(String... strings){
        System.out.println(letterCombinations("234"));
    }

    private static Map<String, String> numChar = new HashMap<>();
    static{
        numChar.put("2","abc");
        numChar.put("3","def");
        numChar.put("4","ghi");
        numChar.put("5","jkl");
        numChar.put("6","mno");
        numChar.put("7","pqrs");
        numChar.put("8","tuv");
        numChar.put("9","wxyz");
    }
    public static List<String> letterCombinations(String digits) {
        List<String> rel = new ArrayList<>();
        if(digits==null || digits.length()==0){
            return rel;
        }

        for(int i = 0; i<digits.length();i++){
            if(i==0){
                String chars = numChar.get(digits.substring(0,1));
                // the first item
                for(int j = 0; j<chars.length();j++){
                    rel.add(chars.substring(j,j+1));
                }
            }else{
                String num = digits.substring(i,i+1);
                String chars = numChar.get(num);
                int len = rel.size();
                for(int k = 0; k<len;k++){
                    String relK = rel.get(k);
                    rel.set(k, relK + chars.substring(0,1));
                    for(int j = 1; j<chars.length();j++){
                        rel.add(relK + chars.substring(j,j+1));
                    }
                }
            }
        }
        return rel;

    }
}
