package zy.leetcode.linked.solution24;

import zy.leetcode.linked.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curNode = dummy;
        ListNode first = null;
        ListNode second = null;
        ListNode nextHead = null;
        while(curNode!=null && curNode.next!=null && curNode.next.next!=null){


            first = curNode.next;
            second = first.next;
            nextHead = second.next;

            // swap
            curNode.next = second;
            second.next = first;
            first.next = nextHead;

            curNode = first;
        }
        return dummy.next;
    }

    private static void test1(){
        Solution sol = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode dummy = sol.swapPairs(l1);
        ListNode.outputAll(dummy);
    }

    public static void main(String...strings){
        test1();
    }
}
