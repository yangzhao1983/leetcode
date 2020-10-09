package zy.leetcode.twopointers.solution142;

import zy.leetcode.linked.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            slow = slow.next;
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            if(fast == null) break;
            if(fast==slow) break;
        }
        if(fast ==null) return null;

        ListNode pre = head;
        while(pre != fast){
            pre = pre.next;
            fast = fast.next;
        }
        return pre;
    }
}
