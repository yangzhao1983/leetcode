package zy.leetcode.tree.solution117;

import zy.leetcode.tree.Node;

import java.util.LinkedList;

public class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            while(len >0){
                Node n = q.poll();
                len --;
                if(len > 0){
                    n.next = q.peek();
                }
                if(n.left != null){
                    q.add(n.left);
                }
                if(n.right != null){
                    q.add(n.right);
                }
            }
        }
        return root;
    }
}
