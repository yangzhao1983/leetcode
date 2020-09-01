package zy.leetcode.linked.solution160;

import zy.leetcode.linked.ListNode;

import java.util.Stack;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null){
            stackA.push(curA);
            curA = curA.next;
        }

        while (curB != null){
            stackB.push(curB);
            curB = curB.next;
        }

        ListNode ans = null;

        while(!stackA.isEmpty() && !stackB.isEmpty() && stackA.peek() == stackB.peek()){
            ans = stackA.pop();
            stackB.pop();
        }

        return ans;
    }
}
