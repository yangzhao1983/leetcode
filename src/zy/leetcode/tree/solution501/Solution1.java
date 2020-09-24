package zy.leetcode.tree.solution501;

import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    /**
     * if root last == cur, cnt++, if cnt > max, clean list, add cur to the list, max = cnt
     * if root last == cur, cnt++, if cnt == max, add cur to the list
     * if root last != cur, cnt = 0. last = cur
     *
     * @param root
     * @return
     */

    private int max = 0;
    private int cnt = 0;
    private int last = Integer.MIN_VALUE;
    private List<Integer> record = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        doDFS(root);
        int[] ans = new int[record.size()];
        for(int i = 0; i < record.size(); i++){
            ans[i] = record.get(i);
        }
        return ans;
    }
    private void doDFS(TreeNode root){
        if(root == null) return;
        doDFS(root.left);
        if(last == root.val){
            cnt ++;
            if(cnt == max) record.add(root.val);
            else if (cnt > max){
                record.clear();
                record.add(root.val);
                max = cnt;
            }
        }else{
            cnt = 1;
            last = root.val;
            if(cnt == max) record.add(root.val);
        }
        doDFS(root.right);
    }
}
