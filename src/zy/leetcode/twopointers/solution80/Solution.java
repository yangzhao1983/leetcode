package zy.leetcode.twopointers.solution80;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * 3 pointers.
     * home: where to move the element
     * cur: the pos where val of element is different from that of previous element
     * forward: the pos where where val of element is the same with that of that of cur
     * if forward - cur < 2, if cur != home, move nums[cur] to nums[home], home++
     * move cur until nums[cur] != nums[forward]
     * forward = cur
     * <p>
     * the first cur is home
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }else if(nums.length <= 2){
            return nums.length;
        }

        int cur = 0;
        int forward = 0;
        int home = -1;

        while (cur < nums.length) {

            int count = 0;
            while (forward < nums.length && nums[forward] == nums[cur]) {
                count++;
                if (count <= 2) {
                    if (forward != home && home >= 0) {
                        nums[home] = nums[forward];
                        home++;
                    }
                } else if (home == -1) {
                    home = forward;
                }

                forward++;
            }
            cur = forward;
        }

        return home < 0 ? nums.length : home;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        int[] nums = {1,1,1,2,2,3};
        Assert.assertEquals(5, sol.removeDuplicates(nums));
    }
}
