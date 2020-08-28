package zy.leetcode.graph.solution332;

import org.junit.Test;

import java.util.*;

public class Solution {
    /**
     * put tickets to map<String, PriorityQueue>
     *
     * @param tickets
     * @return
     */
    private List<String> ans = new ArrayList<>();
    private Set<String> ap = new HashSet<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            String first = ticket.get(0);
            String second = ticket.get(1);
            ap.add(first);
            ap.add(second);
            map.computeIfAbsent(first, x->new PriorityQueue<String>()).add(second);
        }

        doDFS(map, "JFK");
        Collections.reverse(ans);

        return ans;
    }

    private void doDFS(Map<String, PriorityQueue<String>> map, String cur){
        while(map.containsKey(cur) && map.get(cur).size()>0){
            String next = map.get(cur).poll();
            doDFS(map, next);
        }
        ans.add(cur);
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        List<List<String>> tickets = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("JFK");
        l1.add("SFO");
        tickets.add(l1);
        List<String> l2 = new ArrayList<>();
        l2.add("JFK");
        l2.add("ATL");
        tickets.add(l2);

        List<String> l3 = new ArrayList<>();
        l3.add("SFO");
        l3.add("ATL");
        tickets.add(l3);

        List<String> l4 = new ArrayList<>();
        l4.add("ATL");
        l4.add("JFK");
        tickets.add(l4);

        List<String> l5 = new ArrayList<>();
        l5.add("ATL");
        l5.add("SFO");
        tickets.add(l5);

        List<String> ans = sol.findItinerary(tickets);
        System.out.println();
    }
}
