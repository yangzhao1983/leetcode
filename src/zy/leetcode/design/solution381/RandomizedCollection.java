package zy.leetcode.design.solution381;

import org.junit.Test;

import java.util.*;

public class RandomizedCollection {

    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean exist = map.containsKey(val) && map.get(val).size() > 0;
        // hash
        map.computeIfAbsent(val, x->new HashSet<>()).add(list.size());

        // list
        list.add(val);

        return !exist;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean exist = map.containsKey(val) && map.get(val).size() >0;
        // hash
        if(exist){
            Set<Integer> indices = map.get(val);
            Iterator<Integer> iter = indices.iterator();
            int pos = iter.next();
            int last = list.get(list.size()-1);
            int lastPos = list.size()-1;

            list.set(pos, last);
            list.remove(list.size()-1);

            indices.remove(pos);
            map.get(last).remove(lastPos);
            if (pos < lastPos) {
                map.get(last).add(pos);
            }
        }

        return exist;
    }

    /** Get a random element from the collection. */
    /**
     * store all elements in a list,
     * total is the size of the list.
     * randomly select one num from total.
     *
     * insert is O(1)
     * remove?
     *
     * @return
     */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }

    @Test
    public void test(){
        RandomizedCollection rc = new RandomizedCollection();
        rc.insert(0);
        rc.remove(0);
        rc.insert(-1);
        rc.remove(0);
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());

        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
