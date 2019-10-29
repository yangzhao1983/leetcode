package zy.leetcode;

/**
 * Created by kaiser_zhao on 28/04/2019.
 */
public class Solution24 {
    public static void main(String...strings){

        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;

        printListNode(swapPairs(ln1));
    }

    public static void printListNode(ListNode lns){

        while(lns!=null){
            System.out.println(lns.val);
            lns = lns.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        return doSwapPairs(null,head);
    }

    public static ListNode doSwapPairs(ListNode preHead, ListNode head) {

        if(head == null || head.next == null ) {
            return head;
        }else{
            ListNode preFirst = preHead;
            ListNode first = head;
            ListNode second = first.next;
            ListNode followingSecond = second.next;
            if(preFirst!=null){
                preFirst.next = second;
            }
            second.next = first;
            first.next = followingSecond;
            doSwapPairs(first,followingSecond);
            return second;
        }
    }
}
