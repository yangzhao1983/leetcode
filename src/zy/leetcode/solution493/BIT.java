package zy.leetcode.solution493;

/**
 * Created by kaiser_zhao on 26/07/2019.
 */
public class BIT {
    public static void main(String...strings){
        int[] a = {1,3,2,3,1};
        int sum = reversePairs(a);
        int[] a1 = {2,4,3,5,1};
        int sum1 = reversePairs(a1);
        System.out.println(sum);
        System.out.println(sum1);
        int[] a2 = {7,4,3,5,1};
        System.out.println(reversePairs(a2));
        int[] a3 = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePairs(a3));
    }

    public static int reversePairs(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i =0; i<nums.length;i++){
            if(min>nums[i]){
                min = nums[i];
            }
            if(max < nums[i]){
                max = nums[i];
            }
        }

        int n = max - min + 1;
        int[] bit = new int[n+1];
        for(int i = 0; i<bit.length;i++){
            bit[i] = 0;
        }
        int sum = 0;
        for(int i = nums.length - 1; i>-1; i--){
            sum += query(nums[i] - min + 1, bit);
            update(2*nums[i] + 1, bit);
        }
        return sum;
    }

    private static void update(int index, int[]bit){
        while(index < bit.length){
            bit[index] += 1;
            index += (index & -index);
        }
    }

    private static int query(int index, int[]bit) {
        int sum = 0;
        while(index > 0){
            sum += bit[index];
            index -= (index & -index);
        }
        return sum;
    }

    private static void printArray(String prefix ,int[] nums){
        System.out.println("Start=============" + prefix);
        for(int num : nums){
            System.out.println(num);
        }
        System.out.println("End=============" + prefix);
    }
}
