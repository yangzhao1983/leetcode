package zy.leetcode.tree.solution429;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Deque<Node> q = new LinkedList<>();
        q.add(root);
        int size = 1;
        int nextSize = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            Node n = q.poll();
            if(cnt == 0){
                ans.add(new ArrayList<>());
            }
            ans.get(ans.size()-1).add(n.val);
            if(n.children!=null){
                for(Node child : n.children){
                    q.add(child);
                }
                nextSize += n.children.size();
            }
            cnt++;
            if(cnt == size){
                size = nextSize;
                nextSize = 0;
                cnt = 0;
            }
        }
        return ans;
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
