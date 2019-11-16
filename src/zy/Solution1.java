package zy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiser_zhao on 20/06/2019.
 */
public class Solution1 {

    private static Node findCommonAncestor(Node node1, Node node2){
        List<Node> ancestors1 = findAncestors(node1);
        List<Node> ancestors2 = findAncestors(node2);

        for(Node n1 : ancestors1){
            for(Node n2 : ancestors2){
                if(n1 == n2){
                   return n1;
                }
            }
        }
        return null;
    }

    private static List<Node> findAncestors(Node node){
        List<Node> ancestors = new ArrayList<>();
            while(node!=null){
                ancestors.add(node);
                node = node.parent;
        }
        return ancestors;
    }
}

class Node {
    Node parent = null;
    List<Node> children = new ArrayList<>();
}
