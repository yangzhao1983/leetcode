package zy.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    /**
     * generate node tree from string separated by comma
     *
     * @param s
     * @return
     */
    public static TreeNode generateTree(String s){

        String[] ss = s.split(",");
        List<Integer> list = new ArrayList<>();
        for(String item : ss){
            if(item.equals("null")){
                list.add(null);
            }else{
                list.add(Integer.parseInt(item));
            }
        }

        // create queue
        LinkedList<TreeNode> queue = new LinkedList<>();

        // create head
        TreeNode head = new TreeNode(list.get(0));

        // put head to queue
        queue.push(head);

        // get two items from list, if list is out of space, get null, break;
        // if not null, create leftNode and rightNode
        // get item from head of queue, attach leftNode and rightNode to it.
        // of not null, put leftNode and rightNode to queue.
        int i = 1;
        while(true){
            if(i >= list.size()){
                break;
            }

            TreeNode curNode = queue.removeFirst();

            if(list.get(i) == null){
                curNode.left = null;
            }else{
                curNode.left = new TreeNode(list.get(i));
                queue.add(curNode.left);
            }

            i++;
            if(i >= list.size()){
                break;
            }

            if(list.get(i) == null){
                curNode.right = null;
            }else{
                curNode.right = new TreeNode(list.get(i));
                queue.add(curNode.right);
            }

            i++;
        }
        return head;
    }
}
