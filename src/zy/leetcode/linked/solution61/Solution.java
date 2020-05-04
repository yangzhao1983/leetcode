package zy.leetcode.linked.solution61;

import zy.leetcode.linked.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }

        // length of link list
        int len = 0;
        ListNode cur = head;
        while(cur!=null){
            len++;
            cur = cur.next;
        }

        k = k % len;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode forward = dummy;
        ListNode defence = dummy;

        // move forward to k
        for(int i = 0; i < k; i++){
            forward = forward.next;
        }

        while(forward.next != null){
            forward = forward.next;
            defence = defence.next;
        }

        forward.next = dummy.next;
        dummy.next = defence.next;
        defence.next = null;

        return dummy.next;
    }

    public void test1(){

    }
}
