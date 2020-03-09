package zy.leetcode.linked.solution2;

import zy.leetcode.linked.ListNode;

public class Solution {
    // for each loop, nodeA != null && nodeB != null
    // get the number, nA + nB + nLeft, create new node,
    // if nA + nB <=9, put it to the new node
    // else, nLeft = nA + nB - 9, put 9 to new node
    // nLeft = nodeA/B + nLeft - 9,
    // nodeA/nodeB == null, if nLeft != 0, create new node
    private boolean carry = false;
    private ListNode head = new ListNode(-1);
    private ListNode curNode = head;
    private int nLeft = 0;

    private void createNewNode(int left, int right){
        int sum = left + right + (carry? 1 : 0);
        nLeft = sum > 9 ? sum - 10: sum;
        carry = sum > 9 ? true: false;
        ListNode newNode = new ListNode(nLeft);
        curNode.next = newNode;
        curNode = curNode.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        while(l1 !=  null && l2 != null){
            createNewNode(l1.val, l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode singleRel = null;
        if(l1 != null ){
            singleRel = l1;
        }

        if(l2 != null ){
            singleRel = l2;
        }

        while(singleRel != null){
            createNewNode(singleRel.val,0);
            singleRel = singleRel.next;
        }

        if(carry){
            ListNode newNode = new ListNode(1);
            curNode.next = newNode;
        }

        return head.next;
    }

    private static void test1(){

        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l21.next = l22;
        l22.next = l23;

        Solution sol = new Solution();
        ListNode first = sol.addTwoNumbers(l11, l21);

        ListNode.outputAll(first);
    }

    private static void test2(){

        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(8);
        l11.next = l12;


        ListNode l21 = new ListNode(0);


        Solution sol = new Solution();
        ListNode first = sol.addTwoNumbers(l11, l21);

        ListNode.outputAll(first);
    }

    public static void main(String...strings){
        test2();
    }
}
