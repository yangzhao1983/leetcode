package zy.leetcode.linked.solution19;

/**
 * Created by kaiser_zhao on 14/08/2019.
 */
public class TwoPointer {
    public static void main(String...strings){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = removeNthFromEnd(node1, 2);
        System.out.println("========");
        while(head!=null){
            System.out.println(head.val);
            head= head.next;
        }
        node1 = new ListNode(1);
        node2 = new ListNode(2);

        node1.next = node2;

        head = removeNthFromEnd(node1, 1);
        System.out.println("========");
        while(head!=null){
            System.out.println(head.val);
            head= head.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        int distance = 0;
        while(p1!=null){
            p1= p1.next;
            distance++;
            if(distance > n+1){
                p2=p2.next;
            }
        }

        if(distance >= n+1){
            p2.next = p2.next.next;
        }else{
            head = head.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

