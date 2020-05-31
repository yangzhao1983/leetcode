package zy.leetcode.array.solution1431;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        List<Boolean> ans = new ArrayList<>();

        for(int candy : candies){
            if(candy > max) max = candy;
        }

        for(int i = 0 ; i <candies.length; i++){
            ans.add(extraCandies >= max - candies[i]);
        }
        return ans;
    }
}
