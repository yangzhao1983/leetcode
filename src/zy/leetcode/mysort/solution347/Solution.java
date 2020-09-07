package zy.leetcode.mysort.solution347;

import javafx.util.Pair;

import java.nio.channels.Pipe;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private int[] ans;

    public int[] topKFrequent(int[] nums, int k) {
        ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        Pair<Integer, Integer>[] pair = new Pair[map.size()];
        int i = 0;
        for(int key : map.keySet()){
            pair[i++] = new Pair<>(key, map.get(key));
        }

        quickSort(pair, 0, pair.length-1, k, 0);
        return ans;
    }

    private void quickSort(Pair<Integer, Integer>[] pair, int l, int r, int k, int ansIndex){
        // do quick sort
        // len_left (including q) >= k, return pair[0, k]
        // len_left < k, return pair[0, k] + pair[q] + quickSort(pair, q + 1, r, k - 1 -(q - l))
        int picked = (int) (Math.random() * (r - l + 1)) + l;
        swap(pair, l, picked);
        int pivot = pair[l].getValue();
        int index = l;
        for(int i = l + 1; i <= r; i++){
            if(pair[i].getValue() >= pivot){
                swap(pair, index + 1, i);
                index++;
            }
        }
        swap(pair, l, index);

        if(k <= index - l){
            quickSort(pair, l, index - 1, k, ansIndex);
        }else{
            for(int i = l; i <= index; i++){
                ans[ansIndex++] = pair[i].getKey();
            }
            if(k > index - l + 1){
                quickSort(pair, index + 1, r, k - (index-l + 1), ansIndex);
            }
        }
    }

    private void swap(Pair<Integer, Integer>[] pair, int from, int to){
        if(from == to) return;
        Pair<Integer, Integer> tmp = pair[from];
        pair[from] = pair[to];
        pair[to] = tmp;
    }
}
