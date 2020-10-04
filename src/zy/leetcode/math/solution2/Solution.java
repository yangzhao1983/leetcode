package zy.leetcode.math.solution2;

import zy.leetcode.linked.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        int carry = 0;
        while(cur1!=null && cur2 != null){
            int sum = cur1.val + cur2.val + carry;
            carry = sum/10;
            sum = sum%10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        ListNode left = null;
        if(cur1!=null) left =cur1;
        else left = cur2;

        while(left != null){
            int sum = carry + left.val;
            carry = sum/10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            left = left.next;
        }

        if(carry == 1) cur.next = new ListNode(1);

        return head.next;
    }
}
