package zy.leetcode.tree.solution572;

import org.junit.Test;
import zy.leetcode.tree.TreeNode;

public class Solution {
    /**
     * dfs s,
     * dfs s and t
     *
     * @param s
     * @param t
     * @return
     */
    private boolean ans = false;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        dfs(s,t);
        return this.ans;
    }

    private void dfs(TreeNode s, TreeNode t){
        if(s!=null){
            if(compareDFS(s, t)){
                this.ans = true;
                return;
            }else{
                dfs(s.left,t);
                if(this.ans) return;
                dfs(s.right,t);
            }
        }
    }

    private boolean compareDFS(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        } else if( s == null || t== null) {
            return false;
        }else if(s.val != t.val){
            return false;
        }else{
            return compareDFS(s.left, t.left) && compareDFS(s.right, t.right);
        }
    }
}
