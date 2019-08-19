package zy.leetcode.tree.solution105;

import zy.leetcode.tree.TreeNode;

import java.util.*;

/**
 * Created by kaiser_zhao on 15/08/2019.
 */
public class RecurseLR {
    public static void main(String...strings){
        testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
        testCase6();
    }

    private static void testCase6(){
        int[] preorder = new int[] {4,1,2,3};
        int[] inorder = new int[] {1,2,3,4};
        TreeNode.output(buildTree(preorder,inorder),"");
    }

    private static void testCase1(){
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        TreeNode.output(buildTree(preorder,inorder),"");
    }

    private static void testCase5(){
        int[] preorder = new int[] {1,2,3};
        int[] inorder = new int[] {3,2,1};
        TreeNode.output(buildTree(preorder,inorder),"");
    }

    private static void testCase4(){
        int[] preorder = new int[] {1,2,3};
        int[] inorder = new int[] {1,2,3};
        TreeNode.output(buildTree(preorder,inorder),"");
    }

    private static void testCase2(){
        int[] preorder = new int[] {3};
        int[] inorder = new int[] {3};
        TreeNode.output(buildTree(preorder,inorder),"");
    }

    private static void testCase3(){
        int[] preorder = new int[] {};
        int[] inorder = new int[] {};
        TreeNode.output(buildTree(preorder,inorder),"");
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }

        Map<Integer, Integer> inIndices = new HashMap();
        Set<Integer> preIndices = new HashSet<Integer>();

        for(int i = 0; i<inorder.length; i++){
            inIndices.put(inorder[i], i);
            preIndices.add(preorder[i]);
        }

        return build(preorder, 0, inorder, 0, inorder.length-1, inIndices, preIndices);
    }

    private static TreeNode build(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> mapIndexOfIn, Set<Integer> setPre){

        if(inStart > inEnd){
            return null;
        }

        // first node of pre order is the parent of the subtree
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        setPre.remove(rootVal);

        // 1 find the index for parent node in in order.
        int inOrderRootIndex = mapIndexOfIn.get(rootVal);

        // 2 nodes at the left side of it in in order can be built into the left child tree. instart->index-1
        int nextInLeftStart = inStart;
        int nextInLeftEnd = inOrderRootIndex - 1;

        // 3 nodes at the right side of it in in order can be built into the right child tree. index+1->inend
        int nextInRightStart = inOrderRootIndex + 1;
        int nextInRightEnd = inEnd;

        // 4 get left tree from [nextInLeftStart, nextInLeftEnd] of inOrder, with preStart+1
        TreeNode left = build(preorder, preStart+1, inorder, nextInLeftStart, nextInLeftEnd, mapIndexOfIn, setPre);

        // *5 after left tree is created, listPre.size nodes have been inserted to tree.
        int nextRootIndexPre = preorder.length-setPre.size();

        // 6 get right tree from [nextInRightStart, nextInRightEnd] of inOrder, with inOrderRootIndex - inStart + 1
        TreeNode right = build(preorder, nextRootIndexPre, inorder, nextInRightStart, nextInRightEnd, mapIndexOfIn, setPre);

        // 7 insert left tree
        root.left =left;

        // 8 insert right tree
        root.right = right;

        // 9 return root
        return root;
    }
}
