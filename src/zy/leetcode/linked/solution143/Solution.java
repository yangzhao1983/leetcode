package zy.leetcode.linked.solution143;

import org.junit.Test;
import zy.leetcode.linked.ListNode;

public class Solution {
    public void reorderList(ListNode head) {
        if(head ==null) return;

        int cnt = 0;
        ListNode curH = head;
        while(curH!=null){
            cnt++;
            curH = curH.next;
        }

        if(cnt < 3) return;
        int half = cnt/2;

        ListNode[] lna = new ListNode[cnt-half-1];

        int pos = 0;

        curH = head;
        ListNode last = head;
        while(curH!=null){
            if(pos > half){
                lna[pos - half -1] = curH;
                last.next = null;
            }
            pos++;
            last =curH;
            curH = curH.next;
        }

        curH = head;
        ListNode curN = head.next;
        for(int i = lna.length-1; i>=0; i--){
            curH.next = lna[i];
            lna[i].next = curN;
            curH = curN;
            curN = curH.next;
        }
    }

    @Test
    public void test1(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Solution sol = new Solution();
        sol.reorderList(n1);
        System.out.println();
    }

    @Test
    public void test2(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Solution sol = new Solution();
        sol.reorderList(n1);
        System.out.println();
    }
}
