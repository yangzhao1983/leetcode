package zy.leetcode.linked.solution86;

import org.junit.Test;
import zy.leetcode.linked.ListNode;

public class Solution {
    /**
     * 1.find next node, n1 with val >= x
     * 2.start from n1, find the next node, n2 with val < x
     * 3.insert n2 before n1, start from n2.next, do #1
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node1 = dummy;
        ListNode node2 = null;

        while(node1.next != null && node1.next.val < x){
            node1 = node1.next;
        }

        if(node1.next == null){
            return dummy.next;
        }

        node2 = node1.next;

        while(node2!= null && node2.next != null){

            while(node2.next!=null && node2.next.val >= x){
                node2 = node2.next;
            }

            if(node2.next == null){
                break;
            }

            ListNode tmp1 = node1.next;
            ListNode tmp2 = node2.next.next;
            node1.next = node2.next;
            node1.next.next = tmp1;
            node1 = node1.next;

            node2.next = tmp2;
        }

        return dummy.next;
    }
}
