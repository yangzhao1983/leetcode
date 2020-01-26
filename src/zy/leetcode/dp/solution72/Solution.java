package zy.leetcode.dp.solution72;

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2 == null ? 0 : word2.length();
        }

        if (word2 == null || word2.length() == 0) {
            return word1 == null ? 0 : word1.length();
        }

        int m = word1.length();
        int n = word2.length();

        int[][] operations = new int[m + 1][n + 1];

        // operations[i][j] is num of operations required for changing word1[0..i] to word2[0..j]
        // border conditions:
        //    operations[i][0] = i
        //    operations[0][j] = j
        // status transfer equation:
        // in case word[i] == word[j]
        //    operations[i][j] = min(operations[i-1][j], operations[i][j-1], operations[i][j] -1 ) + 1
        // else:
        //    operations[i][j] = min(operations[i-1][j], operations[i][j-1], operations[i][j]) + 1
        for (int i = 0; i < m + 1; i++) {
            operations[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            operations[0][j] = j;
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    operations[i][j] = min(operations[i - 1][j], operations[i][j - 1], operations[i-1][j-1] - 1) +1;
                } else {
                    operations[i][j] = min(operations[i - 1][j], operations[i][j - 1], operations[i-1][j-1]) + 1;
                }
            }
        }
        return operations[m][n];
    }

    private int min(int first, int second, int third) {
        if (first > second) {
            return second > third ? third : second;
        } else {
            return first > third ? third : first;
        }
    }

    private static void test1(String... strings) {
        System.out.println(new Solution().minDistance("horse", "ros"));
    }

    public static void main(String... strings) {
        test1();
    }
}
