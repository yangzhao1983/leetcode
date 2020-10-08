package zy.leetcode.tree.solution337;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;
import zy.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Pair<TreeNode, Boolean>, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        // for given root
        // 1. one of its child is stolen
        // 2. neither of its children is stolen, so root can be stolen
        return Math.max(doRob(root, true), doRob(root, false));
    }

    private int doRob(TreeNode root, boolean stolenRoot){
        if(root == null) return 0;
        Pair<TreeNode, Boolean> key = new Pair<TreeNode, Boolean>(root, stolenRoot);
        if(map.containsKey(key)) return map.get(key);
        int rel = 0;
        if(stolenRoot){
            rel = root.val + doRob(root.left, false) + doRob(root.right, false);
        }
        else{
            rel = Math.max(doRob(root.left, false), doRob(root.left, true)) +
                    Math.max(doRob(root.right, false), doRob(root.right, true));
        }
        map.put(key,rel);
        return rel;
    }
}
