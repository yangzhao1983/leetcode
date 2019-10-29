package zy.leetcode;

/**
 * Created by kaiser_zhao on 25/09/2018.
 */
public class Solution2 {
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jw = 0;
        int sum = 0;
        ListNode start = null;
        ListNode next = null;
        ListNode current = null;
        int l1V = 0;
        int l2V = 0;

        boolean l2Done = false;
        boolean l1Done = false;
        while(true){

            if( l1Done && l2Done){
                if(jw > 0){
                    next = new ListNode(1);
                    current.next = next;
                }
                break;
            }

            sum += jw;

            if(!l1Done){
                l1V = l1.val;
                l1Done = l1.next == null;
                l1 = l1.next;
                sum += l1V;
            }

            if(!l2Done){
                l2V = l2.val;
                l2Done = l2.next == null;
                l2 = l2.next;
                sum += l2V;
            }

            jw = sum/10;
            next = new ListNode(sum%10);

            if(start == null){
                start = next;
                current = start;
            }else{
                current.next = next;
            }

            current = next;

            sum = 0;
        }

        return start;
    }

    public final static void main(String...strings){
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode start = addTwoNumbers(l1, l2);
        while(start != null){
            System.out.println(start.val);
            start = start.next;
        }

        l1 = new ListNode(0);
        l2 = new ListNode(1);
        start = addTwoNumbers(l1, l2);
        while(start != null){
            System.out.println(start.val);
            start = start.next;
        }

        l1 = new ListNode(2);
        l2 = new ListNode(9);
        start = addTwoNumbers(l1, l2);
        while(start != null){
            System.out.println(start.val);
            start = start.next;
        }

        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l2 = new ListNode(9);
        start = addTwoNumbers(l1, l2);
        while(start != null){
            System.out.println(start.val);
            start = start.next;
        }

        l1 = new ListNode(0);
        l2 = new ListNode(0);
        start = addTwoNumbers2(l1, l2);
        while(start != null) {
            System.out.println(start.val);
            start = start.next;
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}