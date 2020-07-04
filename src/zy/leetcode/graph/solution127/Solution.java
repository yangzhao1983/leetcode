package zy.leetcode.graph.solution127;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {
    private Map<String, List<Integer>> edges = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> wordToId = new HashMap<>();
        List<String> idToWord = new ArrayList<>();
        int id = 0;
        for(String word : wordList){
            wordToId.put(word, id++);
            idToWord.add(word);
        }
        if(!wordList.contains(beginWord)){
            wordToId.put(beginWord, id);
            idToWord.add(beginWord);
        }

        if(!wordToId.containsKey(endWord)){
            return 0;
        }

        int ans = 0;
        makeEdges(wordToId);

        Pair<String, Integer> begin = new Pair<>(beginWord, 1);
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(begin);

        // Visited
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        // BFS
        while(!q.isEmpty()){
            Pair<String, Integer> now = q.poll();
            // find edges
            String nowStr = now.getKey();

            List<Integer> candidates = new ArrayList<>();
            for(int i =0; i< nowStr.length();i++){
                String s = nowStr.substring(0,i) + "*" + nowStr.substring(i+1);
                if(edges.get(s)!=null) candidates.addAll(edges.get(s));
            }
            for(Integer candidate : candidates){
                Integer newLen = now.getValue() + 1;
                String canStr = idToWord.get(candidate);
                if(canStr.equals(endWord)){
                    return newLen;
                }else if (!visited.containsKey(canStr)){
                    q.add(new Pair<>(canStr, newLen));
                    visited.put(canStr, true);
                }
            }
        }
        return ans;
    }

    private void makeEdges(Map<String, Integer> wordToId){
        for(String word : wordToId.keySet()){
            for(int i =0; i< word.length();i++){
                String s = word.substring(0,i) + "*" + word.substring(i+1);
                edges.computeIfAbsent(s, x->new ArrayList<>()).add(wordToId.get(word));
            }
        }
    }


    @Test
    public void test1(){
        Solution sol = new Solution();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        int ans = sol.ladderLength(beginWord,endWord,wordList);
        Assert.assertEquals(5, ans);
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        String beginWord = "a", endWord = "c";
        List<String> wordList = new ArrayList<>();
        wordList.add("a");
        wordList.add("b");
        wordList.add("c");
        int ans = sol.ladderLength(beginWord,endWord,wordList);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test3(){
        Solution sol = new Solution();
        String beginWord = "hot", endWord = "dog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dog");
        int ans = sol.ladderLength(beginWord,endWord,wordList);
        Assert.assertEquals(0, ans);
    }
}
