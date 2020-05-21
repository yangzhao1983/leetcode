package zy.leetcode.dp.solution85;

import com.sun.tools.internal.ws.wscompile.WsgenTool;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int ans = 0;
        int[][][] dp = new int[matrix.length][matrix[0].length][2];
        int area = 0;
        // for each cell,
        // 1. record how many '1's are there in the left
        // 2. record how many '1's are there above it.
        // calculate the max area until now.
        for (int i = 0; i < dp[0].length; i++) {
            if (matrix[0][i] == '1') {
                if (i == 0) {
                    dp[0][i][0] = 1;
                } else {
                    dp[0][i][0] = dp[0][i - 1][0] + 1;
                    if (dp[0][i][0] > ans) ans = dp[0][i][0];
                }
                dp[0][i][1] = 1;
            }
            if (dp[0][i][1] > ans) ans = dp[0][i][1];
        }

        for (int i = 1; i < dp.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0][0] = 1;
                dp[i][0][1] = dp[i - 1][0][1] + 1;
                if (dp[i][0][1] > ans) ans = dp[i][0][1];
            }
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < dp.length; i++) {
            stack.clear();
            stack.push(-1);
            int j = 1;
            stack.push(0);

            for (; j < dp[i].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + 1;
                    if(dp[i][j][1] > ans) ans = dp[i][j][1];
                }

                while(stack.peek()!=-1 && dp[i][j][1] <= dp[i][stack.peek()][1])
                    ans = Math.max(dp[i][stack.pop()][1] * (j - stack.peek() - 1), ans);

                stack.push(j);
            }

            while (stack.peek() > -1) {
                area = dp[i][stack.pop()][1] * (j - stack.peek() - 1);
                if (area > ans) ans = area;
            }
        }
        return ans;
    }

    @Test
    public void test0() {
        Solution sol = new Solution();
        char[][] matrix = {{'1'}};
        Assert.assertEquals(1, sol.maximalRectangle(matrix));
    }

    @Test
    public void test1() {
        Solution sol = new Solution();
        char[][] matrix = {{'0', '1'}, {'0', '1'}};
        Assert.assertEquals(2, sol.maximalRectangle(matrix));
    }

    @Test
    public void test2() {
        Solution sol = new Solution();
        char[][] matrix = {
                {'0', '1', '1', '0', '1'},
                {'1', '1', '0', '1', '0'},
                {'0', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '0'}
        };
        Assert.assertEquals(9, sol.maximalRectangle(matrix));
    }
}
