package io.fengchao.leetcode.problems;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        Solution solution = new Solution();
        solution.gameOfLife(input);
    }
}

class Solution {
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                change(board, i, j);
            }
        }
        after(board);

    }

    private void change(int[][] board, int x, int y) {
        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1},
                {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        int counter = 0;
        for(int i = 0; i < 8; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                if(board[nx][ny] == 1 || board[nx][ny] == 3) {
                    counter++;
                }
            }
        }

        if(board[x][y] == 1) {
            if(counter < 2) {
                board[x][y] = 3;
            } else if (counter <=3) {

            } else if(counter > 3) {
                board[x][y] = 3;
            }
        } else {
            if(counter == 3) {
                board[x][y] = 2;
            }
        }
    }

    private void after(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }

            }
        }
    }
}
