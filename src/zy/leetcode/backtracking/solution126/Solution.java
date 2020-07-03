package zy.leetcode.backtracking.solution126;

import com.sun.javafx.scene.control.behavior.AccordionBehavior;
import org.junit.Test;

import java.util.*;

public class Solution {

    /**
     * 1. create graph
     * endWord should be in ids
     * word: id
     * Integer i->List<Integer> edges
     * cost[id] cost from beginWord to id->word
     *
     *
     * 2. BFS
     * now -> edges[now], record it by list
     * End: id=id_of_endWord, get one solution
     * or cost[to] < cost[now]
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> wordToId = new HashMap<>();
        List<String> idToWord = new ArrayList<>();
        int id = 0;
        for(String s : wordList){
            if (!wordToId.containsKey(s)) {
                wordToId.put(s, id++);
                idToWord.add(s);
            }
        }
        int target = -1;
        if(!wordToId.containsKey(endWord)){
            return ans;
        }else{
            target = wordToId.get(endWord);
        }

        if (!wordToId.containsKey(beginWord)) {
            wordToId.put(beginWord, id++);
            idToWord.add(beginWord);
        }

        ArrayList<Integer>[] edges = new ArrayList[wordToId.size()];

        for (int i = 0; i <idToWord.size(); i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < idToWord.size()-1;i++){
            for(int j = i+1; j<idToWord.size(); j++){
                int cnt = 0;
                for(int k = 0; k < beginWord.length(); k++){
                    if(idToWord.get(i).charAt(k)!=idToWord.get(j).charAt(k)) cnt++;
                }
                if(cnt == 1){
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }
        int[] cost = new int[wordToId.size()];

        Arrays.fill(cost, Integer.MAX_VALUE);
        List<String> path = new ArrayList<>();

        LinkedList<List<Integer>> q = new LinkedList<>();
        List<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordToId.get(beginWord));
        cost[wordToId.get(beginWord)] = 0;

        q.addFirst(tmpBegin);
        while(!q.isEmpty()){
//            int len = q.size();
//            while(len > 0){
                List<Integer> now = q.pollLast();
                int last = now.get(now.size()-1);
                if(last == target){
                    List<String> rel = new ArrayList<>();
                    for(int x : now){
                        rel.add(idToWord.get(x));
                    }
                    ans.add(rel);
                }else{
                    for (int i = 0; i < edges[last].size(); i++) {
                        int to = edges[last].get(i);
                        if (cost[last] + 1 <= cost[to]) {
                            cost[to] = cost[last] + 1;
                            ArrayList<Integer> rel = new ArrayList<>(now);
                            rel.add(to);
                            q.addFirst(rel);
                        }
                    }
                }
//                len--;
//            }
        }

        return ans;
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
        List<List<String>> ans = sol.findLadders(beginWord,endWord,wordList);
        System.out.println();
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        String beginWord = "a", endWord = "c";
        List<String> wordList = new ArrayList<>();
        wordList.add("a");
        wordList.add("b");
        wordList.add("c");
        List<List<String>> ans = sol.findLadders(beginWord,endWord,wordList);
        System.out.println();
    }
}
