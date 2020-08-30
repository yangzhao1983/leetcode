package zy.leetcode.graph.solution841;

import java.util.List;

public class Solution {
    private int[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new int[n];
        doDFS(rooms, 0);

        for(int status : visited){
            if(status == 0) return false;
        }

        return true;
    }

    private void doDFS(List<List<Integer>> rooms, int start){
        if(visited[start]==1) return;

        visited[start] = 1;
        for(int key : rooms.get(start)){
            doDFS(rooms, key);
        }
    }
}
