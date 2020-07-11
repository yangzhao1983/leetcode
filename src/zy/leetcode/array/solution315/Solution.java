package zy.leetcode.array.solution315;

import org.junit.Test;

import java.util.*;

public class Solution {
    // BIT
    private int[] bit;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        if(nums==null || nums.length==0) return ans;

        // Initialize bit
        bit = new int[nums.length + 1];

        // sort
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        // compress
        int[] compressedA = compress(copy);

        // map num to id
        Map<Integer, Integer> numToId = new HashMap<>();
        for(int i = 0; i < compressedA.length; i++){
            numToId.put(compressedA[i], i);
        }

        for(int i = nums.length-1; i>=0; i--){
            int id = numToId.get(nums[i]);
            updateNext(id + 1);
            ans.add(0, preSum(id));
        }

        return ans;
    }

    private int[] compress(int[] a){
        List<Integer> compressed = new ArrayList<>();
        compressed.add(a[0]);
        for(int i = 1; i < a.length; i++){
            if(a[i]!=a[i-1]) compressed.add(a[i]);
        }
        int[] compressedA = new int[compressed.size()];

        int i = 0;
        for(int num : compressed){
            compressedA[i++] = num;
        }
        return compressedA;
    }

    private void updateNext(int cur){
        bit[cur]++;
        int next = getNext(cur);
        while(next < bit.length){
            bit[next] ++;
            next = getNext(next);
        }
    }

    private int getNext(int cur){
        return cur + (cur & -cur);
    }

    private int getParent(int cur){
        return cur - (cur & -cur);
    }

    private int preSum(int cur){
        int sum = bit[cur];
        int parent = getParent(cur);
        while(parent >0){
            sum += bit[parent];
            parent = getParent(parent);
        }
        return sum;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] nums = {2,0,1};
        List<Integer> list = sol.countSmaller(nums);
        System.out.println();
    }
}
