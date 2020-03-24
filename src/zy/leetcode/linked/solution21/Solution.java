package zy.leetcode.linked.solution21;

import zy.leetcode.linked.ListNode;

import java.util.LinkedList;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode curNode = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curNode.next = l1;
                l1 = l1.next;
            }else{
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        ListNode left = null;
        if(l1 == null){
            left = l2;
        }else{
            left = l1;
        }

        curNode.next = left;
        return head.next;
    }

    private static void test1(){
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        Solution sol = new Solution();
        ListNode.outputAll(sol.mergeTwoLists(l11,l21));
    }

    public static void main(String...strings){
        test1();
    }
}
