package zy.leetcode.linked.solution92;

import zy.leetcode.linked.ListNode;

import java.awt.*;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // find pre_m
        // find n
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode mPreNode = null;
        ListNode nNode = null;
        ListNode nNextNode = null;

        int count = 0;

        while(cur.next!=null && count < n){
            if(count == m-1){
                mPreNode = cur;
            }
            cur = cur.next;
            count++;
        }

        if(count < m){
            return dummy.next;
        }

        nNode = cur;
        nNextNode = nNode.next;

        ListNode newTail = reverse(mPreNode.next, nNode);
        mPreNode.next = nNode;
        newTail.next = nNextNode;

        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode tail){
        if(head == tail){
            return head;
        }

        ListNode newTail = reverse(head.next, tail);
        newTail.next = head;

        return head;
    }
}
