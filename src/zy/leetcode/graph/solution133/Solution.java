package zy.leetcode.graph.solution133;

import zy.leetcode.graph.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    private Map<Integer, Node> cloned = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        return doDeepClone(node);
    }

    private Node doDeepClone(Node root){
        if(cloned.containsKey(root.val)) return cloned.get(root.val);
        Node node = new Node(root.val);
        cloned.put(node.val, node);
        if(root.neighbors == null || root.neighbors.size() == 0){
            return node;
        }
        for( Node child : root.neighbors){
            if(!cloned.containsKey(child.val))node.neighbors.add(doDeepClone(child));
            else node.neighbors.add(cloned.get(child.val));
        }
        return node;
    }
}
