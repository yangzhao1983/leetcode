package zy.leetcode.tree.solution109;

import zy.leetcode.linked.ListNode;
import zy.leetcode.tree.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode ls = head;
        int len = 0;
        while(ls!=null){
            ls = ls.next;
            len++;
        }
        return createTree(head, len);
    }

    /**
     * return the root the the tree
     * 1. len==0, return null
     * 2. len==1, return head
     * 3. mid: len/2, root index=len/2, left: head, len/2; right: mid-next, len-len/2-1
     *
     * @param head
     * @param len
     * @return
     */
    private TreeNode createTree(ListNode head, int len){
        if(len==0) return null;
        if(len==1) return new TreeNode(head.val);
        int mid = len/2;
        int i = 0;
        ListNode cur = head;
        while(i++<mid) cur = cur.next;
        TreeNode root = new TreeNode(cur.val);
        root.left = createTree(head, mid);
        root.right = createTree(cur.next, len-mid-1);
        return root;
    }
}
