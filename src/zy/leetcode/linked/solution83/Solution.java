package zy.leetcode.linked.solution83;

import zy.leetcode.linked.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode forward = head;
        while(forward != null){
            while(forward != null && forward.val == cur.val){
                forward = forward.next;
            }
            cur.next = forward;
            cur = forward;
        }
        return dummy.next;
    }
}
