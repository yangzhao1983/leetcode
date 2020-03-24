package zy.leetcode.backtracking.solution22;

import zy.leetcode.linked.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // backtrack.
        // for given combination, if number of ) > (, then discard the it
        backTrack(0,0,"",n);
        return ans;
    }

    private void backTrack(int numOfRight, int numOfLeft, String combination, int numOfPa){
        if(numOfLeft == numOfPa && numOfRight == numOfPa){
            ans.add(combination);
            return;
        }

        if(numOfLeft < numOfPa){
            backTrack(numOfRight, numOfLeft+1,combination + "(", numOfPa);
        }

        if(numOfRight<numOfLeft){
            if(numOfLeft < numOfRight+1){
                return;
            }else{
                backTrack(numOfRight+1, numOfLeft,combination + ")", numOfPa);
            }
        }
    }
    private static void test1(){
        Solution sol = new Solution();
        List<String> list = sol.generateParenthesis(3);
        for(String s: list){
            System.out.println(s);
        }
    }
    public static void main(String...strings) {
        test1();
    }
}
