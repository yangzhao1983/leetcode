package zy.leetcode.array.solution189;

/**
 * Created by kaiser_zhao on 2019/10/15.
 */
public class ModK2 {

    public static void main(String...strings){
        testcase2();
        testcase1();
    }

    private static void testcase1(){
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        for(int i : nums){
            System.out.println(i);
        }
    }


    private static void testcase2(){
        int[] nums = {1,2,3,4,5,6};
        rotate(nums, 2);
        for(int i : nums){
            System.out.println(i);
        }
    }


    public static void rotate(int[] nums, int k) {
        // boundary check
        if(nums==null || nums.length <= 1){
            return;
        }

        if(k%nums.length == 0){
            return;
        }else{
            k = k%nums.length;
        }

        int count = 0;
        int cur = 0;
        int temp = nums[0];
        int start = 0;
        while(count < nums.length){
            int nextPos = cur + k;
            nextPos %= nums.length;

            temp = nums[nextPos];
            nums[nextPos] = nums[start];
            nums[start] = temp;

            if(nextPos == start){
                start++;
                cur = start;
            }else{
                cur = nextPos;
            }

            count ++;
        }
    }
}
