package com.grove.leetcode.app.dfs;

public class App79 {
    boolean[][] visited;
    int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
                visited[i][j] = false;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int start) {
        visited[i][j] = true;
        if (board[i][j] != word.charAt(start)) {
            return false;
        }
        if (start == word.length() - 1) {
            return true;
        }

        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];

            if (!isInArea(newX, newY) || visited[newX][newY]) {
                continue;
            }
            if (dfs(board, word, newX, newY, start + 1)) {
                return true;
            }
            visited[newX][newY] = false;
        }
        return false;
    }

    private boolean isInArea(int newX, int newY) {
        return newX >= 0 && newY >= 0 && newX < visited.length && newY < visited[0].length;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][] {{'a','a','a','a'}, {'a','a','a','a'}, {'a','a','a','a'}};

        App79 app79 = new App79();
        app79.exist(chars, "aaaaaaaaaaaaa");
    }
}
