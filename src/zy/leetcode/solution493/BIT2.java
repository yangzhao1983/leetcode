package zy.leetcode.solution493;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by kaiser_zhao on 31/07/2019.
 */
public class BIT2 {
    /**
     * Methods for creating and updating BIT.
     */
    static private void update(int[] bit, int cur){
        while(cur < bit.length){
            bit[cur]++;
            cur += calculateRightestOne(cur);
        }
    }

    static private int query(int[] bit, int cur){
        int sum = 0;
        while(cur > 0){
            sum += bit[cur];
            cur -= calculateRightestOne(cur);
        }
        return sum;
    }

    private static int reversePairs(int[] nums){

        Set<Long> numsSet = new TreeSet<Long>();
        // get sorted Set for nums
        for(int num : nums){
            numsSet.add(Long.valueOf(num));
            numsSet.add(2 * Long.valueOf(num)+1);
        }

        // set rank for numbers in set
        int rank = 0;
        Map<Long, Integer> numsMap = new HashMap<Long, Integer>();
        for(Long numL : numsSet){
          numsMap.put(numL, rank ++);
        }

        int[] bit = new int[numsSet.size() + 1];

        int sum = 0;
        for(int i = nums.length - 1; i >=0; i--){
            sum += query(bit, numsMap.get(Long.valueOf(nums[i]))+1);
            int actualTwoIndex = numsMap.get(Long.valueOf(nums[i]) * 2+1) + 1;
            update(bit, actualTwoIndex);
        }
        return sum;
    }

    static private int calculateRightestOne(int index){
        return index & (-index);
    }

    public static void main(String...strings){
        int[] nums = {2,1};
        int sum = reversePairs(nums);
        System.out.println(sum);

        int[] nums2 = {1,3,2,3,1};
        sum = reversePairs(nums2);
        System.out.println(sum);

        int[] nums3 = {2,4,3,5,1};
        sum = reversePairs(nums3);
        System.out.println(sum);


        int[] nums4 = {7,4,3,5,1};
        sum = reversePairs(nums4);
        System.out.println(sum);

        int[] nums5 = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        sum = reversePairs(nums5);
        System.out.println(sum);
    }
}
