package zy.leetcode.design.solution460;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {
    @Test
    public void test1(){
        LFUCache cache = new LFUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);

        Assert.assertEquals(1, cache.get(1));
        cache.put(3, 3);    // evicts key 2
        Assert.assertEquals(-1, cache.get(2));
        Assert.assertEquals(3, cache.get(3));
        cache.put(4, 4);    // evicts key 1.
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(3, cache.get(3));
        Assert.assertEquals(4, cache.get(4));
    }

    @Test
    public void test2(){
        LFUCache cache = new LFUCache( 0 /* capacity */ );

        cache.put(0, 0);

        Assert.assertEquals(0, cache.get(0));
    }
}

/**
 * int[] a, a[capacity]
 *
 * get
 * if exist, return, freq++, else return -1
 * put
 * if exist, freq++, if not exit, reach capacity,remove min(freq), recent
 *
 * map1 key:val
 * map2 key:freq
 * map3 freq: linked set
 * map4 freq: first key
 *
 * get:
 * map1.get = null, return -1
 * map1.get != null
 *      freq = map2.gey(key)
 *      map2.put(key,freq+1)
 *      map3.get(map2.get(key)).remove key, if map3.get(map2.get(key))==empty, remove it, if minFreq = freq, minFreq++
 *      if map4.get(freq) == key, map4.put(freq, key.next)
 *      map3.put(freq+1, {key})
 *
 *
 * put:
 * if map1.contains key
 * map1.put(key, val)
 * freq = map2.get(key)
 * map3.get(map2.get(key)).remove key, if map3.get(map2.get(key))==empty, remove it,
 * if minFreq = freq, minFreq++
 * if map4.get(freq) == key, map4.put(freq, key.next)
 * map3.put(freq+1, {key})
 *
 * if not map1.contains key
 * if map1.size < capacity
 *      map1.put(key,val)
 *      map2.put(key,1)
 *      map3.get(1), add key, if map3.get(1) == null, minFreq=1;map4.1 = key
 *
 * if map1.size == capacity,
 *
 * map1.key = val
 * map2.put(key,1)
 * map3.minFreq.remove(map4.minFreq),
 *      if map3.minFreq is not empty, map4.minFreq = map3.minFreq.next
 *      else map4.minFreq = null
 * map3.1.add key, map4.1 = key
 * minFreq = 1
 *
 */
class LFUCache {
    private Map<Integer, Integer> keyValMap = new HashMap<>();
    private Map<Integer, Integer> keyFreqMap = new HashMap<>();
    private Map<Integer, LinkedHashSet<Integer>> freqLS = new HashMap<>();
    private Map<Integer, Integer> firstKey = new HashMap<>();
    private int minFreq = 0;
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(keyValMap.containsKey(key) && capacity > 0){
            freqPlus(key);
            return keyValMap.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(capacity==0) {
            keyValMap.put(key, value);
            return;
        }

        if(keyValMap.containsKey(key)){
            keyValMap.put(key, value);
            freqPlus(key);
        }else if(keyValMap.size() < capacity){
            addNewItem(key, value);
        }else{
            removeLRU();
            addNewItem(key, value);
        }
    }

    private void freqPlus(int key){
        int oldFreq = keyFreqMap.get(key);

        // remove it from old freq
        freqLS.get(oldFreq).remove(key);
        if(freqLS.get(oldFreq).isEmpty()){
            freqLS.remove(oldFreq);
            firstKey.remove(oldFreq);
            if(minFreq==oldFreq) minFreq++;
        }else{
            firstKey.put(oldFreq, freqLS.get(oldFreq).iterator().next());
        }

        // add it to freq+1
        int newFreq = oldFreq + 1;
        keyFreqMap.put(key, newFreq);
        if(freqLS.containsKey(newFreq)){
            freqLS.get(newFreq).add(key);
        }else{
            LinkedHashSet<Integer> newKeys = new LinkedHashSet<>();
            newKeys.add(key);
            freqLS.put(newFreq, newKeys);
            firstKey.put(newFreq, key);
        }
    }

    private void addNewItem(int key, int val){
        keyValMap.put(key, val);
        keyFreqMap.put(key,1);
        minFreq = 1;
        if(freqLS.containsKey(1)){
            freqLS.get(1).add(key);
        }else{
            LinkedHashSet<Integer> newKeys = new LinkedHashSet<>();
            newKeys.add(key);
            freqLS.put(1, newKeys);
            firstKey.put(1, key);
        }
    }

    private void removeLRU(){
        // first item to be removed
        int key = firstKey.get(minFreq);
        keyValMap.remove(key);
        keyFreqMap.remove(key);

        freqLS.get(minFreq).remove(firstKey.get(minFreq));
        // second item to be first
        if(freqLS.get(minFreq).isEmpty()){
            firstKey.remove(minFreq);
            freqLS.remove(minFreq);
        }else{
            firstKey.put(minFreq, freqLS.get(minFreq).iterator().next());
        }
    }
}
