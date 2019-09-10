package zy.leetcode.tree.solution100;

import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kaiser_zhao on 2019/9/10.
 */
public class ResolveByPreorder {

    public static void main(String...strings){
//         testcase1();
//        testcase2();
        testcase3();
//        TreeNode.output(head, "=");
    }

    private static TreeNode head = null;

    private static void testcase3(){
        String s = "5,-685,2970,-755,-462,2770,3620,null,-714,-649,434,373,2913,3337,4201,"+
                "null,null,null,-497,-400,-95,313,1620,2838,null,3228,3574,3874,4262,-589,-484,"+
                "null,-225,-183,null,240,null,1357,2342,null,null,2988,3262,3434,null,3658,3885,"+
                "null,null,-622,null,null,null,-381,null,null,null,150,null,1237,1538,2235,2593,"+
                "null,3072,null,null,3349,3490,null,3760,null,4187,null,null,null,-325,74,null,"+
                "701,1246,1439,1583,2136,2249,2553,2661,3053,3174,null,3384,3465,null,3686,3855,"+
                "3971,null,null,null,null,null,527,913,null,1283,null,null,null,null,1945,2219,"+
                "null,null,2370,null,null,2694,3007,null,3109,null,null,null,null,null,null,null,"+
        "null,null,null,4058,519,624,712,972,null,null,1736,1954,null,null,null,2467,2692,"+
                "null,null,null,null,3115,null,4100,-203,null,null,null,null,725,null,1227,1670,"+
                "1745,1952,2030,2427,null,null,null,null,null,null,null,null,null,null,817,1056,"+
                "null,null,null,null,1852,null,null,null,2098,null,null,null,null,null,1133,1834,"+
                "1929";
        String[] ss = s.split(",");
        List<Integer> list = new ArrayList<>();
        for(String item : ss){
            if(item.equals("null")){
                list.add(null);
            }else{
                list.add(Integer.parseInt(item));
            }
        }
//        for(int i = 0; i<list.size();i++){
//            System.out.println(list.get(i));
//        }

        generateTree(list);

        System.out.println(isSameTree(head, head));
    }

    private static void testcase2(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n11 = new TreeNode(2);
        n1.left = n11;

        TreeNode n2 = new TreeNode(1);
        TreeNode n22 = new TreeNode(2);

        n2.right = n22;

//        System.out.println(isSameTree(n1, n2));

    }

    private static void generateTree(List<Integer> list){
        // create queue
        LinkedList<TreeNode> queue = new LinkedList<>();

        // create head
        head = new TreeNode(list.get(0));

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
    }

    private static void testcase1(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n11 = new TreeNode(2);
        TreeNode n12 = new TreeNode(3);
        n1.left = n11;
        n1.right = n12;

        TreeNode n2 = new TreeNode(1);
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(3);

        n2.left = n21;
        n2.right = n22;

        System.out.println(isSameTree(n1, n2));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pList = new ArrayList<>();
        List<Integer> qList = new ArrayList<>();

        preOrderTraverse(p, pList);
        preOrderTraverse(q, qList);

        if(pList.size() == qList.size()){
            for(int i = 0; i < pList.size(); i++){
                if(pList.get(i)==null){
                    if(qList.get(i)!=null){
                        return false;
                    }
                } else if(!pList.get(i).equals(qList.get(i))){
                    return false;
                }
            }
        }else{
            return false;
        }

        return true;

    }

    public static void preOrderTraverse(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        list.add(node.val);
        if(node.left == null && node.right == null){
            return;
        }else{
            if(node.left == null){
                list.add(null);
            }else {
                preOrderTraverse(node.left, list);
            }
            preOrderTraverse(node.right, list);
        }
    }
}
