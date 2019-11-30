package zy.basics.sort;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiser_zhao on 3/21/18.
 */
public class TreeTranverse {
    public static final void main(String...strings){
        TreeNode nodeRoot = new TreeNode();
        nodeRoot.setValue(0);

        TreeNode nodeRoot11 = new TreeNode();
        nodeRoot11.setValue(11);

        TreeNode nodeRoot12 = new TreeNode();
        nodeRoot12.setValue(12);

        TreeNode nodeRoot111 = new TreeNode();
        nodeRoot111.setValue(111);

        TreeNode nodeRoot112 = new TreeNode();
        nodeRoot112.setValue(112);

        TreeNode nodeRoot121 = new TreeNode();
        nodeRoot121.setValue(121);

        TreeNode nodeRoot122 = new TreeNode();
        nodeRoot122.setValue(122);

        nodeRoot.setLeft(nodeRoot11);
        nodeRoot.setRight(nodeRoot12);

        nodeRoot11.setLeft(nodeRoot111);
        nodeRoot11.setRight(nodeRoot112);

        nodeRoot12.setLeft(nodeRoot121);
        nodeRoot12.setRight(nodeRoot122);

        List<TreeNode> list = new ArrayList<TreeNode>();
        tranverse(nodeRoot,list);
    }

    private static void tranverse(TreeNode node, List<TreeNode> list){
        if(node == null){
            return;
        }
        //list.add(node);
        list.add(node);
        tranverse(node.getLeft(), list);
        //System.out.println(node.getValue());
        tranverse(node.getRight(), list);
        outputItem(node, list);
        list.remove(node);

    }

    private static void outputItem(TreeNode node, List<TreeNode> treeNodeList){
        System.out.println("==========================");
        System.out.println("Value of node is " + node.getValue());
        System.out.println("Path is :");
        for(TreeNode tn : treeNodeList){
            System.out.println("-" + tn.getValue());
        }
        System.out.println("==========================");
    }
}

class TreeNode{
    private TreeNode left;
    private TreeNode right;
    private int value;

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }
}