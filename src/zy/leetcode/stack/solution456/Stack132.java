package zy.leetcode.stack.solution456;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by kaiser_zhao on 2019/9/4.
 */
public class Stack132 {
    public static void main(String...strings){
        System.out.println(find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(find132pattern(new int[]{-1, 3, 2, 0}));
    }

    public static boolean find132pattern(int[] nums) {
        // margin check
        if(nums==null || nums.length < 3){
            return false;
        }

        Stack<List<Integer>> rangeStack = new Stack<>();

        // initialize stack with the first value
        List<Integer> range = new ArrayList<>();
        range.add(nums[0]);
        range.add(nums[0]);
        rangeStack.push(range);

        // if num[i] < stack.peek[0], create new range

        // if num[i] < stack.peek[1], get it!

        // if num[i] > stack.peek[1],
        //      note that here, stack.peek[0] is the smallest number (so-called monotonic stack)
        //      pop if num[i] < stack.peek[0],  push [smallest, num[i]]
        //      else pop, until stack.peek[1] > num[i], get it
        //          if there is no result, push [smallest, num[i]]
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= rangeStack.peek().get(0)){
                range = new ArrayList<>();
                range.add(nums[i]);
                range.add(nums[i]);
                rangeStack.push(range);
            }else if(nums[i] < rangeStack.peek().get(1)){
                return true;
            }else{
                int min = rangeStack.peek().get(0);
                rangeStack.pop();
                while(!rangeStack.isEmpty() && nums[i] >= rangeStack.peek().get(1)){
                    rangeStack.pop();
                }

                if(rangeStack.isEmpty() || nums[i] <= rangeStack.peek().get(0)){
                    range = new ArrayList<>();
                    range.add(min);
                    range.add(nums[i]);
                    rangeStack.push(range);
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}
