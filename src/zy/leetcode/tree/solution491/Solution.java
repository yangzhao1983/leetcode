package zy.leetcode.tree.solution491;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * len(nums) = n
     * for nums[i], doDFS(nums, i)
     * loop nums[i+1..n-1], if nums[k] == nums[j], skip nums[j], j > k > i
     * doDFS(nums, m) i+1 =< m <= n-1
     *
     */
    private List<List<Integer>> ans = new ArrayList<>();
    private int n = 0;
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        n = nums.length;
        for(int i = 0; i<n; i++){
            if(!visited.contains(nums[i])){
                visited.add(nums[i]);
                List<Integer> single = new ArrayList<>();
                doDFS(nums, i, single);
            }

        }
        return ans;
    }

    private void doDFS(int[] nums, int si, List<Integer> col){
        if(si == n){
            return;
        }

        if(col.size() == 0){
            col.add(nums[si]);
        }else{
            if(nums[si] >= col.get(col.size() -1)){
                col.add(nums[si]);
                List<Integer> single = new ArrayList<>();
                single.addAll(col);
                ans.add(single);
            }else{
                return;
            }
        }
        Set<Integer> visited = new HashSet<>();

        for(int i = si+1; i<n; i++){
            if(!visited.contains(nums[i])){
                visited.add(nums[i]);
                List<Integer> newCol = new ArrayList<>();
                newCol.addAll(col);
                doDFS(nums, i, newCol);
            }
        }
    }

    @Test
    public void test(){
        Solution sol = new Solution();
        Assert.assertEquals(8, sol.findSubsequences(new int[]{4, 6, 7, 7}).size());
    }
    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.findSubsequences(new int[]{1,1,1}).size());
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.findSubsequences(new int[]{10,8,10}).size());
    }
}
