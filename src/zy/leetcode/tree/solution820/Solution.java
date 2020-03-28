package zy.leetcode.tree.solution820;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * resolve by tree
     * every node is a char of the the string, if node(c2) is parent of node(c1), then in the string c2 is after c1.
     *
     * for each string, add it to the tree.
     * from the root, add the last char as the child of root, and then add the second last as the child of it, and so on.
     *
     * at last, get the sum of (leaf_depth+1).
     *
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {

        // node:depth
        Map<CharTreeNode, Integer> depthes = new HashMap<>();

        // root
        CharTreeNode root = new CharTreeNode();

        for(String word : words){
            CharTreeNode cur = root;
            int depth = 0;
            for(int i = word.length()-1; i>=0; i--){
                cur = cur.getChild(word.charAt(i));
                depth++;
            }
            depthes.put(cur, depth);
        }

        int ans = 0;

        for(CharTreeNode node : depthes.keySet()){
            if(node.count==0){
                ans += depthes.get(node);
                ans += 1;
            }
        }

        return ans;
    }

    private static void test1(){
        String[] words = new String[]{"time", "me", "bell"};
        Solution sol = new Solution();
        System.out.println(sol.minimumLengthEncoding(words));
    }

    private static void test2(){
        String[] words = new String[]{"me","time"};
        Solution sol = new Solution();
        System.out.println(sol.minimumLengthEncoding(words));
    }

    public static void main(String...strings){
        test1();
        test2();
    }
}
class CharTreeNode{
    int count = 0;
    CharTreeNode[] children = new CharTreeNode[26];
    public CharTreeNode(){
    }
    CharTreeNode getChild(char c){
        if(children[c-'a'] == null){
            children[c-'a'] = new CharTreeNode();
        }
        count++;
        return children[c-'a'];
    }
}
