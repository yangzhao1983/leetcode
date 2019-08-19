package zy.leetcode.linked;

/**
 * Created by kaiser_zhao on 14/08/2019.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void outputAll(ListNode head){
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
