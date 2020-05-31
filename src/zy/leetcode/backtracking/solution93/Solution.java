package zy.leetcode.backtracking.solution93;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<String> ans = new ArrayList<>();
    private List<Integer> indices = new ArrayList<>();
    /**
     * start: current start point, [0, len-1)
     * k: index of point, 1-3
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        backtracking(1, s, 0);
        return ans;
    }

    private void backtracking(int indexPoint, String s, int start){
        if(indexPoint == 4){
            String rel = "";
            rel = s.substring(0, indices.get(0)) + "." +
                    s.substring(indices.get(0), indices.get(1)) + "." +
                    s.substring(indices.get(1), indices.get(2)) + "." +
                    s.substring(indices.get(2));
            ans.add(rel);
        }
        for(int i = 1; i <=3; i++){
            int pos = start + i;
            int leftLen = s.length() - pos;
            if((leftLen <=(4-indexPoint) * 3 &&  leftLen >= (4-indexPoint)) && validIPSub(s.substring(start, pos))){
                indices.add(pos);
                backtracking(indexPoint+1, s, pos);
                indices.remove(indices.size()-1);
            }
        }
    }

    private boolean validIPSub(String s){
        if(s.length() > 1 && s.charAt(0) == '0'){
            return false;
        }
        int ipSub = Integer.parseInt(s);

        return ipSub >= 0 && ipSub <= 255;
    }

    @Test
    public void test1(){
        String s = "25525511135";
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.restoreIpAddresses(s).size());
    }

    @Test
    public void test2(){
        String s = "0000";
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.restoreIpAddresses(s).size());
    }
}
