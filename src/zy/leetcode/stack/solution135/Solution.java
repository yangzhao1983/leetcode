package zy.leetcode.stack.solution135;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Solution {
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) return 0;
        int[] candies = new int[ratings.length];
        Stack<Integer> stack = new Stack<>();
        candies[0] = 1;
        for(int i = 1; i < candies.length; i++){
            if(ratings[i] > ratings[i-1]){
                int candy= 1;
                int pos = -1;
                while(!stack.isEmpty()){
                    pos = stack.pop();
                    if(pos < candies.length -1 && ratings[pos]==ratings[pos+1]) candies[pos]=1;
                    else candies[pos] = candy++;
                }
                if(pos > 0 && candies[pos-1] <= candies[pos]){
                    candies[pos-1] = candies[pos] + 1;
                }
                candies[i] = candies[i-1] + 1;
            }else if(ratings[i] == ratings[i-1]){
                if(stack.isEmpty()) candies[i] = 1;
                else  stack.push(i);
            }else{
                stack.push(i);
            }
        }

        if (!stack.isEmpty()) {
            int candy= 1;
            int pos = -1;
            while(!stack.isEmpty()){
                pos = stack.pop();
                if(pos < candies.length -1 && ratings[pos]==ratings[pos+1]) candies[pos]=1;
                else candies[pos] = candy++;
            }
            if(pos > 0 && candies[pos-1] <= candies[pos]){
                candies[pos-1] = candies[pos] + 1;
            }
        }

        int ans = 0;
        for(int cnt : candies){
            ans += cnt;
        }
        return ans;
    }

    @Test
    public void test1(){
        int[] ratings = {1,0,2};
        Solution sol = new Solution();
        Assert.assertEquals(5, sol.candy(ratings));
    }

    @Test
    public void test2(){
        int[] ratings = {1,2,87,87,87,2,1};
        Solution sol = new Solution();
        Assert.assertEquals(13, sol.candy(ratings));
    }

    @Test
    public void test3(){
        int[] ratings = {1,3,2,2,1};
        Solution sol = new Solution();
        Assert.assertEquals(7, sol.candy(ratings));
    }
}
