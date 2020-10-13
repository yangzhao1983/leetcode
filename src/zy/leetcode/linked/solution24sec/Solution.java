package zy.leetcode.linked.solution24sec;

import zy.leetcode.linked.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode first, second;
        while(true){
            first = pre.next;
            if(first == null){
                break;
            }
            second = first.next;
            if(second == null){
                break;
            }
            pre.next = second;
            first.next = second.next;
            second.next = first;
            pre = first;
        }
        return dummy.next;
    }
}
