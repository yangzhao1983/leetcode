package zy.leetcode.backtracking.solution51;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int[][] visited;
    private List<List<String>> ans = new ArrayList<>();
    private int N;
    private List<Integer> rel = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        this.N = n;
        visited = new int[N][N];
        backTracking(0);
        return ans;
    }

    /**
     * status has been set.
     * start: line where the operation is started.
     * find the accessible item from the starting line, set status, and then go to the next line.
     *
     * if no starting line, generate status.
     *
     * after all, rollback status.
     *
     * @param start
     */
    private void backTracking(int start){
        if(start == N){
            // generate ans
            List<String> singleAns = new ArrayList<>();
            for(int i : rel){
                String s = generateLine(i);
                singleAns.add(s);
            }
            ans.add(singleAns);
            return;
        }

        for(int i = 0; i<N;i++){
            if(visited[start][i] == 0){
                forward(start, i);
                rel.add(i);
                backTracking(start+1);
                rollbackStatus(start, i);
                rel.remove(rel.size()-1);
            }
        }
    }

    private String generateLine(int q){
        String s = "";
        for(int i = 0; i < N; i++){
            if(i == q){
                s += "Q";
            }else{
                s+= ".";
            }
        }
        return s;
    }

    private void forward(int hor, int ver){
        updateStatus(hor, ver,true);
    }

    private void updateStatus(int hor, int ver, boolean forward){
        // horizon
        int i = 0;
        while(i < N){
            if (forward)visited[hor][i]++;
            else visited[hor][i]--;
            i++;
        }

        // vertical
        int j = 0;
        while(j < N){
            if(j != hor){
                if (forward )visited[j][ver]++;
                else visited[j][ver]--;
            }
            j++;
        }

        // diag
        i = 1;
        j = 1;
        while(hor + i < N &&  ver + j < N){
            if (forward)visited[hor + i][ver + j]++;
            else visited[hor + i][ver + j]--;
            i++;
            j++;
        }

        i = -1;
        j = -1;
        while(hor + i >= 0 &&  ver + j >= 0){
            if (forward)visited[hor + i][ver + j]++;
            else visited[hor + i][ver + j]--;
            i--;
            j--;
        }

        i = 1;
        j = -1;
        while(hor + i < N &&  ver + j >= 0){
            if (forward)visited[hor + i][ver + j]++;
            else visited[hor + i][ver + j]--;
            i++;
            j--;
        }

        i = -1;
        j = 1;
        while(hor + i >=0 &&  ver + j < N){
            if (forward)visited[hor + i][ver + j]++;
            else visited[hor + i][ver + j]--;
            i--;
            j++;
        }
    }

    private void rollbackStatus(int hor, int ver){
        updateStatus(hor, ver, false);
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        List<List<String>> ans = sol.solveNQueens(4);
        System.out.println();
    }
}
