package zy.leetcode.array.solution238;

/**
 * Created by kaiser_zhao on 08/08/2019.
 */
public class TimeOnSpaceConstant {

    public static void main(String...strings){

        for(int i : productExceptSelf(new int[]{1,2,3,4})){
            System.out.println(i);
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        for(int i = 0; i<nums.length;i++){
            products[i] = 1;
        }


        // input cumulated product from left side
        for(int i = 1; i<nums.length;i++){
            products[i] = products[i-1] * nums[i-1];
        }

        for(int i : products){
            System.out.println(i);
        }

        // input cumulated product from right side
        int rightP = 1;
        for(int i = nums.length - 2; i>=0 ;i--){
            rightP *= nums[i+1];
            products[i] *= rightP;
        }

        return products;
    }
}
