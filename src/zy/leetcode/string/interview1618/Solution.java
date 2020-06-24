package zy.leetcode.string.interview1618;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<String, String> map = new HashMap<>();
    public boolean patternMatching(String pattern, String value) {
        return doMatch(pattern, 0, value, 0);
    }

    /**
     * for pattern[pStart], if it can be found in map, check if it match value[vStart..]
     * if it can not be found in map, try it with "", value[vStart..] respectively, the point is that before
     * try, make sure the string it represent different from the other pattern
     *
     * @return
     */
    private boolean doMatch(String pattern, int pStart, String value, int vStart){
        if(pStart == pattern.length() && vStart == value.length()){
            return true;
        }

        if(pStart == pattern.length() && vStart < value.length()){
            return false;
        }

        String curP = pattern.substring(pStart, pStart + 1);
        if(map.containsKey(curP)){
            String curPStr = map.get(curP);
            if("".equals(curPStr) || (vStart + curPStr.length() <= value.length() && curPStr.equals(value.substring(vStart,
                    vStart + curPStr.length())))){
                return doMatch(pattern, pStart + 1, value, vStart + curPStr.length());
            }else{
                return false;
            }
        }else{
            for(int j = vStart; j <= value.length(); j++){
                String candidate = value.substring(vStart, j);
                if(!candidate.equals(map.get(curP.equals("a") ?
                        "b" : "a"))){
                    map.put(curP, candidate);
                    if(doMatch(pattern, pStart + 1, value, j))
                        return true;
                    map.remove(curP);
                }
            }
            return false;
        }
    }

    @Test
    public void test1(){
        String pattern = "abba", value = "dogcatcatdog";
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.patternMatching(pattern,value));
    }

    @Test
    public void test2(){
        String pattern = "a", value = "";
        Solution sol = new Solution();
        Assert.assertEquals(true, sol.patternMatching(pattern,value));
    }
}
