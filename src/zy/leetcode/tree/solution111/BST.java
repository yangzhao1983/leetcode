package zy.leetcode.tree.solution111;

import zy.leetcode.tree.TreeNode;

import java.util.LinkedList;

/**
 * Created by kaiser_zhao on 2019/9/10.
 */
public class BST {
    public static void main(String...strings){

        testcase3();
    }

    private static void testcase3() {
        String s = "1,2,null,3,null,4,null,5";
        TreeNode head = TreeNode.generateTree(s);
        TreeNode.output(head, "=");
        System.out.println(minDepth(head));
    }

    private static void testcase2() {
        String s = "1,null,2";
        TreeNode head = TreeNode.generateTree(s);
        TreeNode.output(head, "=");
        System.out.println(minDepth(head));
    }

    private static void testcase1() {
        String s = "3,9,20,null,null,15,7";
        TreeNode head = TreeNode.generateTree(s);
        TreeNode.output(head, "=");
        System.out.println(minDepth(head));
    }

    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int count = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(true){
            TreeNode curNode = queue.removeFirst();
            count ++;
            if(curNode==null){
                continue;
            }
            // if cur node is leaf, break
            if(curNode.left == null && curNode.right == null){
                break;
            }else{
                queue.add(curNode.left);
                queue.add(curNode.right);
            }
        }

        return (int)(Math.log(count)/Math.log(2)) + 1;
    }
}
