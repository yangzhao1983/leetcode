package zy.leetcode.linked.solution138;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Node, Node> created = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        return deepCloneNode(head);
    }

    private Node deepCloneNode(Node node){
        if(created.containsKey(node)) return created.get(node);
        else{
            Node newNode = new Node(node.val);
            created.put(node, newNode);
            if(node.random!=null){
                newNode.random = deepCloneNode(node.random);
            }
            if(node.next!=null){
                newNode.next = deepCloneNode(node.next);
            }
            return newNode;
        }
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
