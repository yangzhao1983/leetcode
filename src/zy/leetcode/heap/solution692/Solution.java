package zy.leetcode.heap.solution692;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for(String word : words){
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((x1, x2)->count.get(x1).equals(count.get(x2))?
                x2.compareTo(x1) : count.get(x1) - count.get(x2));

        for(String word : count.keySet()){
            pq.offer(word);
            if(pq.size() > k) pq.poll();
        }

        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()) ans.add(pq.poll());
        Collections.reverse(ans);

        return ans;
    }
}
