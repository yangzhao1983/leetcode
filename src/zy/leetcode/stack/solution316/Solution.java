package zy.leetcode.stack.solution316;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!seen.contains(c)) {
                while (!stack.isEmpty()
                        && map.getOrDefault(stack.peek(), 0) > 1 && c < stack.peek()) {
                    map.put(stack.peek(), map.get(stack.peek()) - 1);
                    seen.remove(stack.peek());
                    stack.pop();
                }
                stack.push(c);
                seen.add(c);
            }else{
                map.put(c, map.get(c) - 1);
            }
        }

        String ans = "";
        while (!stack.isEmpty()) {
            ans = String.valueOf(stack.pop()) + ans;
        }
        return ans;
    }

    @Test
    public void test1() {
        Solution sol = new Solution();
        Assert.assertEquals("abc", sol.removeDuplicateLetters("bcabc"));
    }
}
