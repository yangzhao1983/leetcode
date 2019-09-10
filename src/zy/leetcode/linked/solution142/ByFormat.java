package zy.leetcode.linked.solution142;

import zy.leetcode.linked.ListNode;

/**
 * Created by kaiser_zhao on 2019/9/10.
 */
public class ByFormat {

    public static void main(String...strings){
        testcase1();
        testcase2();
        testcase3();
    }

    private static void testcase3(){
        ListNode n1 = new ListNode(1);

        System.out.println(detectCycle(n1).val);
    }

    private static void testcase2(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        n1.next = n2;
        n2.next = n1;

        System.out.println(detectCycle(n1).val);
    }

    private static void testcase1(){
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        System.out.println(detectCycle(n1).val);
    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == head){
            return head;
        }

        // slow node go forward 1 node each step,
        // fast node go forward 2 nodes each step.
        // until they meet each other
        // if fast node == null, return null.
        ListNode meetPoint = null;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while(fastNode != null && fastNode.next!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode){
                meetPoint = slowNode;
                break;
            }
        }

        if(meetPoint == null){
            return null;
        }

        // two nodes,
        // left node start from head, 1 node each step
        // right node start from meet point, 1 node each step.
        // until they meet each other, return this meet point
        ListNode leftNode = head;
        ListNode rightNode = meetPoint;
        while(leftNode != rightNode){
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }
        return leftNode;
    }
}
