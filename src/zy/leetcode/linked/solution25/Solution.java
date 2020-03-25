package zy.leetcode.linked.solution25;

import zy.leetcode.linked.ListNode;

import java.util.List;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode curDummy = dummy;
        ListNode curHead = head;
        dummy.next = head;
        while(true){
            ListNode curNode = curDummy;

            // get next dummy
            ListNode nextDummy = curHead;

            // get dummy: curDummy

            // get cur_head: curHead

            // get group
            int i = 0;
            for(; i<k; i++){
                if(curNode == null){
                    break;
                }
                curNode = curNode.next;
            }

            if(curNode == null){
                break;
            }

            // set end of group, next_head = next ,next = null
            ListNode nextHead = curNode.next;
            curNode.next = null;

            // reverse group
            curHead = reverse(curHead);

            // dummy.next = returned head
            curDummy.next = curHead;

            // cur_head=next_head
            curHead = nextHead;

            // here the first node(next dummy) should be the last one in the group.
            // first node is new dummy
            curDummy = nextDummy;

            curDummy.next = nextHead;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next==null){
            return head;
        }
        ListNode newLast = head;
        ListNode returnedLast = head.next;
        ListNode nextHead = reverse(head.next);
        returnedLast.next = newLast;
        newLast.next = null;
        return nextHead;
    }

    private static void test1(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution sol = new Solution();
        ListNode ans = sol.reverseKGroup(l1,2);

        ListNode.outputAll(ans);
    }

    private static void test2(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution sol = new Solution();
        ListNode ans = sol.reverseKGroup(l1,3);

        ListNode.outputAll(ans);
    }

    public static void main(String...strings){
        test1();
        test2();
    }
}
