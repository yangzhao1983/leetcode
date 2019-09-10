package zy.leetcode.tree.solution236;

import zy.leetcode.tree.TreeNode;

/**
 * Created by kaiser_zhao on 2019/9/10.
 */
public class ResolveByRecurse {

    public static void main(String...strings){
        testcase1();
    }

    private static void testcase1(){
        TreeNode n1 = new TreeNode(3);
        TreeNode n11 = new TreeNode(5);
        TreeNode n12 = new TreeNode(1);
        TreeNode n111 = new TreeNode(6);
        TreeNode n112 = new TreeNode(2);
        TreeNode n1121 = new TreeNode(7);
        TreeNode n1122 = new TreeNode(4);
        TreeNode n121 = new TreeNode(0);
        TreeNode n122 = new TreeNode(8);

        n1.left = n11;
        n1.right = n12;
        n11.left = n111;
        n11.right = n112;
        n112.left = n1121;
        n112.left = n1122;

        n12.left = n121;
        n12.right = n122;

        System.out.println(lowestCommonAncestor(n1, new TreeNode(5), new TreeNode(1)).val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }

    private static TreeNode find(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return null;
        }

        if(node.val == p.val || node.val == q.val ){
            return node;
        }

        TreeNode leftAns = find(node.left, p, q);

        TreeNode rightAns = find(node.right, p, q);

        if(leftAns != null && rightAns != null){
            return node;
        }else{
            return leftAns == null ? rightAns : leftAns;
        }
    }
}
