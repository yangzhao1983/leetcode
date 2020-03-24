package zy.leetcode.backtracking.solution17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private List<String> ans = new ArrayList<>();
    private Map<String, String> numStrings = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if(digits!=null && digits.length()>0){
            backtracking("", digits);
        }
        return ans;
    }

    private void backtracking(String combination, String nextDigits){
        if(nextDigits.length() == 0){
            ans.add(combination);
        }else{
            String numStr = nextDigits.substring(0,1);
            String strs = numStrings.get(numStr);
            for(int i = 0;i < strs.length();i++){
                backtracking(combination + strs.substring(i,i+1), nextDigits.substring(1));
            }
        }
    }

    private static void test1(){
        Solution sol = new Solution();
        List<String> list = sol.letterCombinations("23");
        for(String str : list){
            System.out.println(str);
        }
    }

    public static void main(String...strings){
        test1();
    }
}
