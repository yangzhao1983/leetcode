package zy.leetcode;

import java.util.Arrays;

/**
 * Created by kaiser_zhao on 2018/10/21.
 */
public class Solution16 {

    public static void main(String...strings){
//        System.out.println(threeSumClosest(new int[]{1,1,1,1}, 0));
//        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 0));
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
    /**
     *
     *  // if i >0 and i < nums.length -2, skip duplicate
     // j = i+1, k = length-1
     // j<k, skip duplicate j
     // j<k, skip duplicate k
     // start = false==> start == true, set isPlus
     // while (j<k)
     //  newTarget = a[i] + a[j] + a[k]
     //  newTarget == traget, return 0
     //  rel = min(abs(newTarget-target), rel)
     //  if newTarget > target && isPlus
     //      k--
     //      skip k dup
     // if newTarget < target && isPlus
     //      j++
     //      skip j dup
     //      isPlus == false
     // if newTarget < target && !isPlus
     //      j++
     //      skip j dup
     // if newTarget > target && !isPlus
     //      k--
     //      skip k dup
     //      isPlus = true
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        // sort
        Arrays.sort(nums);

        int rel = 0;
        boolean start = false;
        // for nums[i:] i in [0, nums.length -2]
        for(int i = 0; i< nums.length-2;i++){
            // if i >0 and i < nums.length -2, skip duplicate
            if(i>0 && i<nums.length-2 && nums[i] == nums[i-1]){
               continue;
            }

            // j = i+1, k = length-1
            int j = i+1;
            int k = nums.length - 1;

            // start = false==> start == true, set isPlus
            int newTarget = nums[i] + nums[j] + nums[k];
            boolean isPlus = false;
            if(!start){
                start = true;
                rel = newTarget - target;
                if(rel>0){
                    isPlus = true;
                }
            }

            // while (j<k)
            while(j<k){
            //  newTarget = a[i] + a[j] + a[k]
                newTarget = nums[i] + nums[j] + nums[k];
            //  newTarget == target, return 0
                if (newTarget == target){
                    return newTarget;
                }
            //  rel = min(abs(newTarget-target), rel)
                if (Math.abs(newTarget-target) < Math.abs(rel)){
                    rel = newTarget - target;
                }

            //  if newTarget > target && isPlus
                if (newTarget > target && isPlus){
                    k--;
                    while(j<k && nums[k]==nums[k+1]){k--;}
            //      k--
            //      skip k dup
                } else if (newTarget < target && isPlus){
            // if newTarget < target && isPlus
            //      j++
            //      skip j dup
            //      isPlus == false
                    j++;
                    while(j<k && nums[j]==nums[j-1]){j++;}
                    isPlus = false;
                } else if (newTarget < target && !isPlus) {
                    // if newTarget < target && !isPlus
                    //      j++
                    //      skip j dup
                    j++;
                    while(j<k && nums[j]==nums[j-1]){j++;}
                }else{
            // if newTarget > target && !isPlus
            //      k--
            //      skip k dup
            //      isPlus = true
                    k--;
                    while(j<k && nums[k]==nums[k+1]){k--;}
                    isPlus = true;
                }
            }
        }
        return target + rel;
    }
}
