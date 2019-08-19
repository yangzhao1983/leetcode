package zy.leetcode.linked.solution82;

import zy.leetcode.linked.ListNode;

/**
 * Created by kaiser_zhao on 14/08/2019.
 */
public class TwoPointers {
    public static void main(String...strings){
        testOne();
        testTwo();
    }

    private static void testOne(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode.outputAll(deleteDuplicates(node1));
    }

    private static void testTwo(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode.outputAll(deleteDuplicates(node1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p1 = dummy;
        ListNode p2 = head;

        int curVal = p2.val;
        p2 = p2.next;

        while(p2!=null){
            if(p2.val != curVal){
                p1 = p1.next;
            }else{
                while(p2!=null && p2.val == curVal){
                    p2 = p2.next;
                }
                p1.next = p2;
            }
            if(p2!=null){
                curVal = p2.val;
                p2 = p2.next;
            }
        }
        return dummy.next;
    }
}
