package zy.leetcode.queue.solution101;

import apple.laf.JRSUIUtils;
import org.junit.Assert;
import org.junit.Test;
import zy.basics.clazz.TestAnonymousClass;
import zy.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * left branch: node->left->right
     * right branch: node->right->branch
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }else if(root.left == null && root.right==null){
            return true;
        }else if(root.left == null || root.right == null){
            return false;
        }

        ArrayDeque<TreeNode> l = new ArrayDeque<>();
        ArrayDeque<TreeNode> r = new ArrayDeque<>();

        l.addLast(root.left);
        r.addLast(root.right);

        TreeNode ltn;
        TreeNode rtn;

        while(!l.isEmpty() && !r.isEmpty()){
            ltn = l.pollFirst();
            rtn = r.pollFirst();

            if(ltn.val != rtn.val){
                return false;
            }

            if(ltn.left == null){
                if(rtn.right != null){
                    return false;
                }
            }else if(rtn.right==null){
                return false;
            }else{
                l.addLast(ltn.left);
                r.addLast(rtn.right);
            }


            if(ltn.right == null){
                if(rtn.left != null){
                    return false;
                }
            }else if(rtn.left==null){
                return false;
            }else{
                l.addLast(ltn.right);
                r.addLast(rtn.left);
            }
        }

        if(!l.isEmpty() || !r.isEmpty()){
            return false;
        }

        return true;
    }

    @Test
    public void test1(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(2);
        TreeNode node111 = new TreeNode(3);
        TreeNode node112 = new TreeNode(4);
        TreeNode node121 = new TreeNode(4);
        TreeNode node122 = new TreeNode(3);

        node1.left = node11;
        node1.right = node12;
        node11.left = node111;
        node11.right = node112;
        node12.left = node121;
        node12.right = node122;

        Solution sol = new Solution();
        Assert.assertEquals(true, sol.isSymmetric(node1));
    }
}
