package zy.leetcode.backtracking.solution51again;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int[][] status;
    private List<List<String>> ans = new ArrayList<>();
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        status = new int[n][n];
        doBackTracking(0, new ArrayList<>());
        return ans;
    }

    private void doBackTracking(int start, List<String> paths) {
        if (start == n) {
            List<String> single = new ArrayList<>();
            single.addAll(paths);
            ans.add(single);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (status[start][i] == 0) {
                // change status
                // change the status for vertical, horizon, diagnose
                changeStatus(start, i, false);

                String path = "";
                for(int j = 0; j < n; j++) path = path + (i == j ? "Q" : ".");

                paths.add(path);

                // doBackTracking for the next line
                doBackTracking(start+1, paths);

                // roll back status
                // roll back status for vertical, horizon, diagnose
                changeStatus(start, i, true);
                paths.remove(paths.size()-1);
            }
        }
    }

    private void changeStatus(int start, int index, boolean rollback) {
        int direction = 1;
        if (rollback) direction = -1;

        status[start][index] += direction;

        // vertical
        for (int v = 0; v < n; v++) {
            if (v != index) status[start][v] += direction;
        }

        // horizon
        for (int h = 0; h < n; h++) {
            if (h != start) status[h][index] += direction;
        }

        // diagnose
        for (int i = 1; start + i < n && index + i < n; i++) {
            status[start + i][index + i] += direction;
        }

        for (int i = 1; start - i >= 0 && index - i >= 0; i++) {
            status[start - i][index - i] += direction;
        }

        for (int i = 1; start - i >= 0 && index + i < n; i++) {
            status[start - i][index + i] += direction;
        }

        for (int i = 1; start + i < n && index - i >= 0; i++) {
            status[start + i][index - i] += direction;
        }
    }
}
