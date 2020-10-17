package zy.leetcode.linked.solution19sec;

import zy.leetcode.linked.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode f = dummy;
        ListNode b = f;
        while(n>0 && f != null){
            f = f.next;
            n--;
        }
        if(f!=null){
            while(f.next != null){
                f = f.next;
                b = b.next;
            }
            b.next = b.next.next;
        }
        return dummy.next;
    }
}
