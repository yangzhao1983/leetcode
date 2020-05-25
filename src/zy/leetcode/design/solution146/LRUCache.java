package zy.leetcode.design.solution146;

import java.util.*;

public class LRUCache {

    private LinkedHashMap<Integer, Integer> nums;
    private int capacity;

    public LRUCache(int capacity) {
        this.nums = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(nums.containsKey(key)){
            int val = nums.get(key);
            nums.remove(key);
            nums.put(key,val);
            return val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(nums.containsKey(key)){
            nums.remove(key);
            nums.put(key,value);
        }else{
            nums.put(key,value);
            if(nums.size() > this.capacity){
                int first = nums.keySet().iterator().next();
                nums.remove(first);
            }
        }
    }
}
