package zy.leetcode.tree.solution590;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        doDFS(root);
        return ans;
    }
    private void doDFS(Node root){
        if(root == null) return;

        if(root.children == null || root.children.size() == 0){
            ans.add(root.val);
            return;
        }
        for(Node node : root.children){
            doDFS(node);
        }
        ans.add(root.val);
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
