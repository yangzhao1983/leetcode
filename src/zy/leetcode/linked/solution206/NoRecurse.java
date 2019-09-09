package zy.leetcode.linked.solution206;

import zy.leetcode.linked.ListNode;

/**
 * Created by kaiser_zhao on 2019/9/9.
 */
public class NoRecurse {

    public static void main(String...strings){
        testcase1();
    }

    private static void testcase1(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode.outputAll(reverseList(n1));
    }
    private static void testcase2(){
        ListNode n1 = new ListNode(1);

        ListNode.outputAll(reverseList(n1));
    }


    public static ListNode reverseList(ListNode head) {
        // if empty, or only one node, return
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = null;
        ListNode curNode = head;
        ListNode oldHead = curNode;

        while(curNode!=null){
            oldHead = curNode.next;
            curNode.next = newHead;
            newHead = curNode;
            curNode = oldHead;
        }

        return newHead;
    }
}
