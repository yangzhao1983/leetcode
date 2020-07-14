package zy.leetcode.linked.solution147;

import zy.leetcode.linked.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            insertToSortList(dummy,cur);
            cur = next;
        }
        return dummy.next;
    }

    private void insertToSortList(ListNode dummy, ListNode node){
        ListNode pre = dummy;
        ListNode post = dummy.next;
        while(post!=null && post.val <= node.val){
            pre = post;
            post = pre.next;
        }
        pre.next = node;
        node.next = post;
    }
}
