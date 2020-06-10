package zy.leetcode.bst.solution109;

import zy.leetcode.linked.ListNode;
import zy.leetcode.tree.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        int len = 0;
        ListNode cur = head;
        while(cur!=null){
            len++;
            cur = cur.next;
        }

        int[] nums = new int[len];

        cur = head;
        len = 0;
        while(cur!=null){
            nums[len++] = cur.val;
            cur = cur.next;
        }

        return buildBST(nums, 0,len-1);
    }

    private TreeNode buildBST(int[] nums, int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start)/2;

        TreeNode root = new TreeNode(nums[mid]);

        TreeNode l = buildBST(nums, start, mid-1);
        TreeNode r = buildBST(nums, mid+1, end);

        root.left = l;
        root.right =r;
        return root;
    }
}
