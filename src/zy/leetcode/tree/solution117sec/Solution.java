package zy.leetcode.tree.solution117sec;

import zy.leetcode.tree.Node;

public class Solution {

    private Node nextStart;
    private Node start;
    private Node last;

    public Node connect(Node root) {
        if(root == null) return null;
        start = root;
        while(start!=null){
            nextStart = null;
            last =null;
            for(Node p = start; p != null; p = p.next){
                if(p.left!=null) handle(p.left);
                if(p.right!=null) handle(p.right);
            }
            start = nextStart;
        }

        return root;
    }

    private void handle(Node node){
        if(nextStart == null){
            nextStart = node;
        }
        if(last != null){
            last.next = node;
        }
        last = node;
    }
}
