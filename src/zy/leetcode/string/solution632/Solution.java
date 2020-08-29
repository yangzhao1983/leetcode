package zy.leetcode.string.solution632;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        // loop nums, get start point, end point.
        // for each point, there is a list contains the indices of the the lists
        // start from start point, first point refers the left,
        // second point refers the right
        // move the second point, until get the targeted scan.
        // move the first point, until the policy is destroyed. record the length
        int[] ans = {-100000, 100000};
        Map<Integer, List<Integer>> allPoints = new HashMap<>();
        int start = 100000;
        int end = -100000;
        int listNum = nums.size();

        for (int i = 0; i < nums.size(); i++) {
            for (int point : nums.get(i)) {
                allPoints.computeIfAbsent(point, x -> new ArrayList<>()).add(i);
                if (point < start) start = point;
                if (point > end) end = point;
            }
        }
        int l, r;
        l = start;

        Map<Integer, Integer> covered = new HashMap<>();

        r = l;
        while (r <= end) {
            // move second pointer
            while (r <= end && covered.size() < listNum) {
                if (allPoints.get(r) != null) {
                    for (int listIdx : allPoints.get(r)) {
                        covered.put(listIdx, covered.getOrDefault(listIdx, 0) + 1);
                    }
                }
                r++;
            }

            if (covered.size() == listNum) {
                if (ans[1] - ans[0] + 1 > r - l) {
                    ans[1] = r - 1;
                    ans[0] = l;
                }

                // move first pointer
                while (l < r) {
                    if (allPoints.get(l) != null) {
                        for (int listIdx : allPoints.get(l)) {
                            covered.put(listIdx, covered.get(listIdx) - 1);
                            if (covered.get(listIdx) == 0) {
                                covered.remove(listIdx);
                            }
                        }
                    }
                    l++;
                    if (covered.size() == listNum) {
                        if (ans[1] - ans[0] + 1> r - l) {
                            ans[1] = r - 1;
                            ans[0] = l;
                        }
                    }else break;
                }
            }
        }
        return ans;
    }

    @Test
    public void test1(){
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        l1.add(4);
        l1.add(10);
        l1.add(15);
        l1.add(24);
        l1.add(26);

        List<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(9);
        l2.add(12);
        l2.add(20);

        List<Integer> l3 = new ArrayList<>();
        l3.add(5);
        l3.add(18);
        l3.add(22);
        l3.add(30);

        list.add(l1);
        list.add(l2);
        list.add(l3);

        Solution sol = new Solution();

        int[] ans = sol.smallestRange(list);
        System.out.println();
    }
}
