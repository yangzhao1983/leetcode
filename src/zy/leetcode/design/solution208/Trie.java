package zy.leetcode.design.solution208;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('@');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode parent = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode curNode = parent.getChild(c);
            if(curNode == null) {
                parent.addChild(c);
                curNode = parent.getChild(c);
            }
            parent = curNode;
        }
        parent.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode parent = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode curNode = parent.getChild(c);
            if(curNode == null) return false;
            parent = curNode;
        }
        if(parent.isEnd) return true;
        else return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode parent = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            TrieNode curNode = parent.getChild(c);
            if(curNode == null) return false;
            parent = curNode;
        }
        return true;
    }
    @Test
    public void test1(){
        Trie trie = new Trie();

        trie.insert("apple");
        Assert.assertEquals(true,trie.search("apple"));   // returns true
        Assert.assertEquals(false,trie.search("app"));     // returns false
        Assert.assertEquals(true,trie.startsWith("app")); // returns true
        trie.insert("app");
        Assert.assertEquals(true,trie.search("app"));     // returns true
    }
}

class TrieNode{
    char val;
    boolean isEnd = false;
    Map<Character, TrieNode> children = new HashMap<>();
    public TrieNode(char val){
        this.val = val;
    }

    /**
     * new child, and then add it to the tree
     *
     * @param childVal
     */
    public void addChild(char childVal){
        if(!children.containsKey(childVal)){
            children.put(childVal, new TrieNode(childVal));
        }
    }

    // get child
    public TrieNode getChild(char val){
        return children.get(val);
    }
}
