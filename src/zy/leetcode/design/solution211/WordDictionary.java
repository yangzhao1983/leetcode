package zy.leetcode.design.solution211;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('@');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode parent = root;
        for(int i = 0; i < word.length();i++){
            char c = word.charAt(i);
            TrieNode cur = parent.getChild(c);
            if(cur==null) parent.addChild(c);
            parent = parent.getChild(c);
        }
        parent.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root, 0);
    }

    public boolean search(String word, TrieNode parent, int cur) {
        if(cur == word.length()){
            if(parent.isEnd) return true;
            else return false;
        }
        char c = word.charAt(cur);
        if(c=='.'){
            for(Character key : parent.children.keySet()){
                if(search(word, parent.children.get(key), cur + 1)) return true;
            }
        }else{
            TrieNode child = parent.getChild(c);
            if(child!=null) return search(word, child, cur+1);
            else return false;
        }
        return false;
    }

    private static class TrieNode{
        char val;
        boolean isEnd = false;
        Map<Character, TrieNode> children = new HashMap<>();
        public TrieNode(char val){
            this.val = val;
        }
        public void addChild(char val){
            children.put(val, new TrieNode(val));
        }
        public TrieNode getChild(char val){
            return children.get(val);
        }
    }
}

