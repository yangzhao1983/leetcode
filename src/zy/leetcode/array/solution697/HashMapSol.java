package zy.leetcode.array.solution697;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kaiser_zhao on 09/08/2019.
 */
public class HashMapSol {

    public static void main(String...strings){
        int[] nums = new int[]{1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            indices.computeIfAbsent(nums[i], x->new ArrayList<Integer>()).add(i);
        }

        // get the maximum frequency and length
        int maxFreq = 0;
        int len = Integer.MAX_VALUE;
        for(List<Integer> l : indices.values()){
            if(l.size()>=maxFreq){
                int curLen = l.get(l.size()-1)-l.get(0)+1;

                if(l.size()>maxFreq){
                    len = curLen;
                    maxFreq = l.size();
                }else{
                    if(curLen < len){
                        len = curLen;
                    }
                }
            }
        }

        return len;
    }
}
