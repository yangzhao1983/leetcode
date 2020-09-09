package zy.leetcode.design.solution173;

import zy.leetcode.tree.TreeNode;

import java.util.LinkedList;

public class BSTIterator {
    private LinkedList<Integer> q = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        doDFS(root);
    }

    private void doDFS(TreeNode root){
        if(root==null) return;

        doDFS(root.left);
        q.addLast(root.val);
        doDFS(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return q.pollFirst();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !q.isEmpty();
    }
}
