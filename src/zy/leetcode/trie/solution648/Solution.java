package zy.leetcode.trie.solution648;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
        StringBuilder sb = new StringBuilder();
        int wordNo = 0;
        for (String word : sentence.split(" ")) {
            if (wordNo++ > 0) sb.append(" ");
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) break;
                cur = cur.children[c - 'a'];
                if(cur.word!=null) break;
            }
            if (cur != root && cur.word != null) sb.append(cur.word);
            else sb.append(word);
        }
        return sb.toString();
    }

    private static class TrieNode {
        String word;
        TrieNode[] children;

        public TrieNode() {
            word = null;
            children = new TrieNode[26];
        }
    }

    @Test
    public void test1() {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ac");
        dictionary.add("ab");
        Solution sol = new Solution();
        Assert.assertEquals("it is ab that this solution is ac", sol
                .replaceWords(dictionary, "it is abnormal that this solution is accepted"));
    }
}
