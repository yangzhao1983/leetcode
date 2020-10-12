package zy.leetcode.hash.solution532;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.event.TreeExpansionListener;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * |a-b| = k
     * a-b = k
     * a-b = -k
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> lMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            // a-b = k, b = a-k
            // a-b = -k, b = a+l
            lMap.put(nums[i]-k, i);
        }
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(lMap.containsKey(nums[i]) && i != lMap.get(nums[i])){
                lMap.remove(nums[i]);
                cnt++;
            }
        }
        return cnt++;
    }

    @Test
    public void test1(){
        int[] nums = {3,1,4,1,5};
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.findPairs(nums, 2));
    }
}
