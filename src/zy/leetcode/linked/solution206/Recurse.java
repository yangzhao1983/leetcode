package zy.leetcode.linked.solution206;

import zy.leetcode.linked.ListNode;

/**
 * Created by kaiser_zhao on 2019/9/9.
 */
public class Recurse {

    public static void main(String...strings){
        testcase2();
    }


    private static void testcase2(){
        ListNode n1 = new ListNode(1);

        recurseReverse(n1);

        ListNode.outputAll(newHead);
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

        recurseReverse(n1);

        ListNode.outputAll(newHead);
    }

    private static ListNode newHead = null;

    public ListNode reverseList(ListNode head) {
        // if empty, or only one node, return
        if (head == null || head.next == null){
            return head;
        }

        recurseReverse(head);

        return  newHead;
    }

    /**
     * Do reverse,and return the tail of the linked list
     *
     * @param head
     * @return
     */
    private static ListNode recurseReverse(ListNode head){
        // if only one node, it should be the new head, and then return
        if(head.next == null){
            newHead = head;
            return head;
        }

        // if more the two nodes,
        // reverse the linked list started with the next node.
        // and then put current node to the tail of the returned linked list
        ListNode newTail = recurseReverse(head.next);
        head.next = null;
        newTail.next = head;
        return head;
    }
}
