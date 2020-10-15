package zy.leetcode.tree.solution117third;

import zy.leetcode.tree.Node;

public class Solution {
    private Node nextStart = null;
    private Node last = null;
    private Node start = null;
    public Node connect(Node root) {
        if(root == null) return null;

        // during dealing ith level nodes, build next links for (i+1)th level.
        start = root;
        while (start!=null) {
            last = null;
            nextStart = null;
            for(Node p = start; p!=null; p = p.next){
                if(p.left != null) handle(p.left);
                if(p.right != null) handle(p.right);
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
