package zy.leetcode.array.solution189;

/**
 * Created by kaiser_zhao on 2019/9/2.
 */
public class ModK {

    public static void main(String...strings){
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        for(int i : nums){
            System.out.println(i);
        }
    }

    public static void rotate(int[] nums, int k) {
        // margin value
        if(nums == null || nums.length < 2){
            return;
        }

        // k % len == 0
        if(k % nums.length == 0){
            return;
        }

        k = k%nums.length;
        int count = 0;
        for(int start = 0; count < nums.length; start++){
            int cur = start;
            int pre = nums[cur];
            int next = 0;
            do{
                next = (cur + k)%nums.length;
                int tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                cur = next;
                count++;
            }while(next != start);
        }
    }
}
