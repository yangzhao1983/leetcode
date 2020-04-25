package zy.leetcode.linked.solution23;

import org.junit.Test;
import zy.leetcode.linked.ListNode;

public class Solution {
    /**
     * for each list, if list != null,
     * check if list.head.val < target, move it to ans
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int empty = 0;
        int min = Integer.MAX_VALUE;
        int selectIndex = -1;
        while(true){
            empty = 0;
            for(int i = 0; i<lists.length; i++){
                if(lists[i]==null){
                    empty++;
                    continue;
                }
                if(lists[i].val < min){
                    selectIndex = i;
                    min = lists[i].val;
                }
            }

            if(empty == lists.length) break;

            cur.next = lists[selectIndex];
            lists[selectIndex] = lists[selectIndex].next;
            cur = cur.next;
            cur.next = null;

            selectIndex = -1;
            min = Integer.MAX_VALUE;

        }
        return head.next;
    }

    @Test
    public void test1(){
        ListNode ln11 = new ListNode(1);
        ListNode ln12 = new ListNode(4);
        ListNode ln13 = new ListNode(5);

        ln11.next = ln12;
        ln12.next = ln13;

        ListNode ln21 = new ListNode(1);
        ListNode ln22 = new ListNode(3);
        ListNode ln23 = new ListNode(4);
        ln21.next = ln22;
        ln22.next = ln23;

        ListNode ln31 = new ListNode(2);
        ListNode ln32 = new ListNode(6);
        ln31.next = ln32;

        Solution sol = new Solution();
        ListNode.outputAll(sol.mergeKLists(new ListNode[]{ln11, ln21, ln31}));
    }
}
