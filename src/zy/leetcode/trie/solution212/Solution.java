package zy.leetcode.trie.solution212;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class Solution {
    private Set<String> ansSet = new HashSet<>();
    private int m;
    private int n;
    private char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || words==null || board.length == 0 || words.length == 0) return new ArrayList<>();

        m = board.length;
        n = board[0].length;
        this.board = board;

        // for words, generate trie node tree
        TrieNode root = new TrieNode('@');
        for(String word : words){
            generateTrie(root, word);
        }

        // backtrack board
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                backtracking(i, j, root, "", new HashSet<>());
            }
        }
        return new ArrayList<>(ansSet);
    }

    private void generateTrie(TrieNode root, String word){
        TrieNode parent = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode cur = parent.children[c-'a'];
            if(cur == null){
                cur = new TrieNode(c);
                parent.children[c-'a'] = cur;
            }
            parent = cur;
        }
        parent.word = word;
    }

    private void backtracking(int row, int col, TrieNode root, String str, Set<Pair<Integer, Integer>> visited){
        if(row < 0 || row == m || col < 0 || col == n) return;
        Pair<Integer, Integer> pair = new Pair<>(row, col);
        if(visited.contains(pair)) return;

        char c = board[row][col];
        TrieNode node = root.children[c-'a'];
        if(node == null) return;
        str += String.valueOf(c);
        if(node.word != null){
            ansSet.add(str);
        }
        visited.add(pair);
        // left
        backtracking(row , col-1, node, str, visited);
        // right
        backtracking(row, col + 1, node, str, visited);

        // top
        backtracking(row -1, col, node, str, visited);

        // bottom
        backtracking(row +1, col, node, str, visited);

        visited.remove(pair);


    }

    private static class TrieNode{
        char val;
        TrieNode[] children;
        String word;
        public TrieNode(char val){
            this.val = val;
            children = new TrieNode[26];
            this.word = null;
        }
    }

    @Test
    public void test1(){
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        Solution sol = new Solution();
        List<String> ans = sol.findWords(board, words);
        System.out.println();
    }

    @Test
    public void test2(){
        char[][] board = {{'a','a'}};
        String[] words = {"a"};
        Solution sol = new Solution();
        List<String> ans = sol.findWords(board, words);
        System.out.println();
    }

    @Test
    public void test3(){
        char[][] board = {{'a','b'},{'c','d'}};
        String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
        Solution sol = new Solution();
        List<String> ans = sol.findWords(board, words);
        System.out.println();
    }
}
