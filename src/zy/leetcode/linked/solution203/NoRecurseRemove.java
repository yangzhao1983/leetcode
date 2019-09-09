package zy.leetcode.linked.solution203;

import zy.leetcode.linked.ListNode;

/**
 * Created by kaiser_zhao on 2019/9/9.
 */
public class NoRecurseRemove {

    public static void main(String...strings){
        testcase1();
    }

    private static void testcase1(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode.outputAll(removeElements(n1, 6));
    }

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        ListNode curNode = head;
        ListNode newDummyHead = new ListNode(-1);
        newDummyHead.next = head;
        ListNode preNode = newDummyHead;

        while(curNode!=null){
            if(curNode.val == val){
                preNode.next = curNode.next;
            }else{
                preNode = curNode;
            }
            curNode = curNode.next;
        }

        return newDummyHead.next;
    }
}
