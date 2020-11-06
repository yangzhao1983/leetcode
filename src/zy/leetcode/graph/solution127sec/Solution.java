package zy.leetcode.graph.solution127sec;

import java.util.*;

public class Solution {

    private Map<String, List<String>> edge;
    private Set<String> wordSet;
    private Map<String, Integer> depth;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        edge = new HashMap<>();
        wordSet = new HashSet<>();
        depth = new HashMap<>();

        // create graph
        for(String word : wordList){
            addEdge(word);
        }
        addEdge(beginWord);
        if(!edge.containsKey(endWord)){
            return 0;
        }

        // do BFS
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        depth.put(beginWord, 1);

        while (!q.isEmpty()) {
            String s = q.poll();
            if (s.equals(endWord)) {
                return depth.get(endWord) / 2 + 1;
            }
            for (String next : edge.get(s)) {
                if (depth.get(next) == Integer.MAX_VALUE) {
                    q.offer(next);
                    depth.put(next, depth.get(s) + 1);
                }
            }
        }
        return 0;
    }

    /**
     * for each word
     * abc->*bc
     * abc->a*c
     * abc->ab*
     * *bc->abc
     * a*c->abc
     * ab*->abc
     */
    private void addEdge(String word) {
        addWord(word);
        char[] cs = word.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char tmp = cs[i];
            cs[i] = '*';
            String newWord = new String(cs);
            addWord(newWord);
            edge.computeIfAbsent(word, x -> new ArrayList<>()).add(newWord);
            edge.computeIfAbsent(newWord, x -> new ArrayList<>()).add(word);
            cs[i] = tmp;
        }
    }

    private void addWord(String word) {
        if (!wordSet.contains(word)) {
            wordSet.add(word);
            depth.put(word, Integer.MAX_VALUE);
        }
    }
}
