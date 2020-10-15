package zy.leetcode.tree.solution116sec;

import zy.leetcode.tree.Node;

public class Solution {
    public Node connect(Node root) {
        //DFS, root.next ->root.right
        doDFS(root);

        Node cur = root;
        while(cur != null){
            Node tmp = cur.next;
            cur.next = null;
            cur = tmp;
        }
        return root;
    }

    private void doDFS(Node root){
        if(root == null) return;
        doDFS(root.left);
        doDFS(root.right);
        Node lr = root.left;
        Node rl = root.right;
        while(lr != null){
            Node tmp = lr.next;
            if(rl!=null) {
                lr.next = rl;
                rl = rl.left;
            }else{
                lr.next = null;
            }
            lr = tmp;
        }

        root.next = root.right;
    }
}

