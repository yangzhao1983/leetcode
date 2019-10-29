package zy.leetcode;

/**
 * Created by kaiser_zhao on 2018/10/28.
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Solution21 {

    public static void main(String...strings){
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        l11.next = l12;
        ListNode l13 = new ListNode(4);
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        l21.next = l22;
        ListNode l23 = new ListNode(4);
        l22.next = l23;
        ListNode ls = mergeTwoLists(l11,l21);
        while(ls!=null){
            System.out.println(ls.val);
            ls = ls.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if (l2==null){
            return l1;
        }

        if(l1.val>l2.val){
            merge(l2, l1);
            return l2;
        }else{
            merge(l1, l2);
            return l1;
        }
    }

    /**
     * the m.val > l.val
     *
     * given l!=null && m!=null
     */
    private static void merge(ListNode l, ListNode m){

        ListNode backup = l;
        ListNode mLast = m;
        ListNode lLast = l;
        while(l!=null && m.val>=l.val){
            lLast = l;
            l = l.next;
        }

        lLast.next = m;

        if(l==null){
            return;
        }else{
            merge(m, l);
        }
    }
}
