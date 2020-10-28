package zy.leetcode.linked.solution237;

import zy.leetcode.linked.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
