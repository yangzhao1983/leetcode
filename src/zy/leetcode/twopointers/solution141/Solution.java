package zy.leetcode.twopointers.solution141;

import zy.leetcode.linked.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next == null) return false;

        ListNode fast = head;
        ListNode slow = head;
        while(true){
            slow = slow.next;

            fast = fast.next;
            if(fast == null) return false;

            fast = fast.next;
            if(fast == null) return false;

            if(slow == fast) return true;
        }
    }
}
