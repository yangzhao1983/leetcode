package zy.leetcode.linked.solution328;

import zy.leetcode.linked.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode even = head.next;
        ListNode tmp;
        while(pre!=null && even != null && even.next!=null){
            tmp = pre.next;
            pre.next = even.next;
            pre = pre.next;
            even.next = pre.next;
            pre.next = tmp;
            even = even.next;
        }

        return head;
    }
}
