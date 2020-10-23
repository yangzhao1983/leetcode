package zy.leetcode.twopointers.solution234;

import zy.leetcode.linked.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        // find the mid
        if(head == null || head.next == null) return true;

        int n = 0;
        ListNode cur = head;
        while(cur!=null){
            n++;
            cur = cur.next;
        }

        int mid = n/2 -1;

        // reverse from head to mid-1
        cur = head;
        ListNode nextHead = cur.next;
        cur.next = null;
        while(mid>0){
            ListNode temp = nextHead.next;
            nextHead.next = cur;
            cur = nextHead;
            nextHead = temp;
            mid--;
        }

        // compare and move
        if(n%2==1){
            // start from cur and nextHead.next
            nextHead = nextHead.next;
        }
        while(cur!=null){
            if(cur.val != nextHead.val) return false;
            cur = cur.next;
            nextHead = nextHead.next;
        }
        return true;
    }
}
