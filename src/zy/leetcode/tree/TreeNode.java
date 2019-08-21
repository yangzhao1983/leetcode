package zy.leetcode.tree;

/**
 * Created by kaiser_zhao on 15/08/2019.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static void output(TreeNode root, String prefix){
        if(root == null){
            return;
        }

        System.out.print(prefix);

        // out put root
        System.out.println(root.val);

        // out put left
        output(root.left, prefix + "=left=");

        // out put right
        output(root.right, prefix+"=right=");
    }
}
