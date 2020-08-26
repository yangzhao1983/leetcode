package zy.leetcode.string.solution17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private Map<Character, String> map = new HashMap<Character, String>();
    private List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) return ans;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        doLetterCombinations(digits, 0, "");
        return ans;
    }

    private void doLetterCombinations(String digits, int si, String path){
        if(si == digits.length()){
            ans.add(path);
        }else{
            String chars = map.get(digits.charAt(si));
            for(int i = 0; i <chars.length(); i++){
                path += chars.substring(i, i+1);
                doLetterCombinations(digits, si+1, path);
                path = path.substring(0, path.length()-1);
            }
        }
    }
}
