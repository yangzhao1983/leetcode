package zy.leetcode.sortandsearch.solution148;

import zy.leetcode.linked.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        ListNode newHead = sort(head);
        return  newHead;
    }

    public ListNode sort(ListNode head){
        if (head==null || head.next == null){
            return head;
        }
        ListNode left = head;
        ListNode right = cut(head);
        ListNode sortedLeft = sort(head);
        ListNode sortedRight = sort(right);

        ListNode sortHead = merge(sortedLeft, sortedRight);

        return sortHead;
    }

    // return the mid point
    private ListNode cut(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        return rightHead;
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(left!=null && right!=null){
            if(left.val < right.val){
                cur.next = left;
                cur = cur.next;
                left = left.next;
            }else{
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
        }

        // if left is still not empty
        if(left!=null){
            cur.next = left;
        }

        // if right is still not empty
        if(right!=null){
            cur.next = right;
        }

        return dummy.next;
    }

    private static void test1(){
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Solution solution = new Solution();
        ListNode head = solution.sort(l1);
        System.out.println(head);
    }

    private static void test2(){
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution solution = new Solution();
        ListNode head = solution.sort(l1);
        System.out.println(head);
    }

    private static void test3(){
        ListNode l1 = null;
        Solution solution = new Solution();
        ListNode head = solution.sort(l1);
        System.out.println(head);
    }

    public static void main(String...strings){
        test3();
    }
}
