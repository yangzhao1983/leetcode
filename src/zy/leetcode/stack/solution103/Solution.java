package zy.leetcode.stack.solution103;

import zy.leetcode.tree.TreeNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    private List<LinkedList<Integer>> lists = new ArrayList<>();

    /***
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        doDFS(root, 1);

        for (int i = 0; i < lists.size(); i++) {
            List<Integer> single = new ArrayList<>();

            while (!lists.get(i).isEmpty()) {
                if (i % 2 == 0) single.add(lists.get(i).pollLast());
                else single.add(lists.get(i).pollFirst());
            }
            ans.add(single);
        }
        return ans;
    }

    private void doDFS(TreeNode root, int level) {
        if (root == null) return;

        if (lists.size() < level) lists.add(new LinkedList<>());
        lists.get(level - 1).addFirst(root.val);

        doDFS(root.left, level + 1);
        doDFS(root.right, level + 1);
    }
}
