package zy.leetcode;

/**
 * Created by kaiser_zhao on 2018/10/27.
 *
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution19 {
    public static void main(String...strings){
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        head.next = n1;
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode cur = head;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
        removeNthFromEnd(head, 2);
        cur = head;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lastLast = head;
        ListNode cur = head;
        int i = 0;
        while(cur!=null){
            i++;
            if(i>n+1){
                lastLast = lastLast.next;
            }
            cur = cur.next;
        }
        if(i>n){
            lastLast.next = lastLast.next.next;
        }else if (i==n){
            head = head.next;
        }

        return head;
    }
}
