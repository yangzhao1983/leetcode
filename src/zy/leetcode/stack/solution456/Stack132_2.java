package zy.leetcode.stack.solution456;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by kaiser_zhao on 2019/10/29.
 */
public class Stack132_2 {

    public static void main(String...strings){
        System.out.println(find132pattern(new int[]{4, 1, 3, 2}));
        System.out.println(find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(find132pattern(new int[]{-1, 3, 2, 0}));
        System.out.println(find132pattern(new int[]{1, 0, 1, -4, -3}));
    }

    public static boolean find132pattern(int[] nums) {
        Stack<List<Integer>> minAndMaxs = new Stack<>();
        if(nums == null || nums.length < 3){
            return false;
        }

        for(int num : nums){
            int min = num;
            if(!minAndMaxs.isEmpty()){
                if(minAndMaxs.peek().get(0) < min){
                    min = minAndMaxs.peek().get(0);
                }
            }

            while(!minAndMaxs.isEmpty()){
                // get top pair
                List<Integer> top = minAndMaxs.pop();
                // if num < top_min, need new interval
                if(num <= top.get(0)){
                    minAndMaxs.push(top);
                    break;
                }else if(num < top.get(1)){
                    // get it!
                    return true;
                }else{
                    continue;
                }
            }

            List<Integer> minAndMax = new ArrayList<>();
            minAndMax.add(min);
            minAndMax.add(num);
            minAndMaxs.push(minAndMax);

        }
        return false;
    }
}
