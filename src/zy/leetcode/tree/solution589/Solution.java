package zy.leetcode.tree.solution589;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if(root == null) return ans;
        doDFS(root);
        return ans;
    }

    private void doDFS(Node root){
        if(root==null) return;
        ans.add(root.val);
        if(root.children != null){
            for(Node child : root.children){
                doDFS(child);
            }
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
