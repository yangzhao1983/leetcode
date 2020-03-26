package zy.leetcode.array.solution999;

public class Solution {
    public int numRookCaptures(char[][] board) {
        int i = 0;
        int j = 0;
        int ans = 0;
        boolean got = false;
        for(; i <board.length; i++){
            j = 0;
            for(; j < board.length;j++){
                if(board[i][j] == 'R'){
                    got = true;
                    break;
                }
            }
            if(got){
                break;
            }
        }
        int next = i-1;
        while(next >= 0){
            if (board[next][j] == 'B') {
                break;
            }else if(board[next][j] == 'p'){
                ans++;
                break;
            }
            next--;
        }

        next = i+1;
        while(next < board.length){
            if (board[next][j] == 'B') {
                break;
            }else if(board[next][j] == 'p'){
                ans++;
                break;
            }
            next++;
        }

        next = j-1;
        while(next >= 0){
            if (board[i][next] == 'B') {
                break;
            }else if(board[i][next] == 'p'){
                ans++;
                break;
            }
            next--;
        }

        next = j+1;
        while(next < board.length){
            if (board[i][next] == 'B') {
                break;
            }else if(board[i][next] == 'p'){
                ans++;
                break;
            }
            next++;
        }

        return ans;
    }

    private static void test1(){
        char[][] board = new char[][]{
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
        };
        Solution sol = new Solution();
        System.out.println(sol.numRookCaptures(board));
    }

    private static void test2(){
        char[][] board = new char[][]{
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'p','p','.','R','.','p','B','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','B','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
        };
        Solution sol = new Solution();
        System.out.println(sol.numRookCaptures(board));
    }

    private static void test3(){
        char[][] board = new char[][]{
                {'.','.','.','.','.','.','.','.'},
                {'.','p','p','p','p','p','.','.'},
                {'.','p','p','B','p','p','.','.'},
                {'.','p','B','R','B','p','.','.'},
                {'.','p','p','B','p','p','.','.'},
                {'.','p','p','p','p','p','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
        };
        Solution sol = new Solution();
        System.out.println(sol.numRookCaptures(board));
    }

    public static void main(String...str){
        test1();
        test2();
        test3();
    }
}
