package com.grove.leetcode.app;

/**
 * 130. 被围绕的区域
 */
public class App130 {

    public void solve(char[][] board) {
        int h = board.length;
        int w = board[0].length;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 只看边缘值
                if (i == 0 || j == 0 || i == h - 1 || j == w - 1) {
                    if (board[i][j] == 'O') {
                        bfs(board, i, j);
                    }
                }
            }

        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }

            }

        }

    }

    private void bfs(char[][] board, int i, int j) {
        int h = board.length;
        int w = board[0].length;
        if (i < 0 || j < 0 || i >= h || j >= w || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }

        board[i][j] = '#';

        bfs(board, i + 1, j);
        bfs(board, i - 1, j);
        bfs(board, i, j + 1);
        bfs(board, i, j - 1);
    }

}
