package zy.leetcode.design.solution380;

import java.util.*;

public class RandomizedSet {

    private List<Integer> nums;
    private Map<Integer, Integer> cnt;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        cnt = new HashMap<>();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean exist = cnt.containsKey(val);
        if(!exist){
            nums.add(val);
            cnt.put(val, nums.size()-1);
        }
        return !exist;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(cnt.containsKey(val)){
            int pos = cnt.get(val);
            cnt.remove(val);
            int last = nums.get(nums.size()-1);
            if(pos < nums.size() - 1){
                cnt.put(last, pos);
            }
            nums.set(pos, last);
            nums.remove(nums.size() - 1);

            return true;
        }else{
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get((int)(Math.random() * nums.size()));
    }
}
