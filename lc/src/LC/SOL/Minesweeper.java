package LC.SOL;

import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper {
    public class Solution {

        int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        public char[][] updateBoard(char[][] board, int[] click) {
            int m = board.length, n = board[0].length;
            if (m == 0) return board;
            Queue<int[]> q = new LinkedList<>();
            q.offer(click);
            while (!q.isEmpty()) {
                int[] node = q.poll();
                int row = node[0], col = node[1];
                if (board[row][col] == 'M') {
                    board[row][col] = 'X';
                } else {
                    int mines = getMines(board, row, col);
                    if (mines == 0) {
                        board[row][col] = 'B';
                        for (int[] d : dirs) {
                            int nextRow = row + d[0];
                            int nextCol = col + d[1];
                            if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length && board[nextRow][nextCol] == 'E') {
                                q.offer(new int[]{nextRow, nextCol});
                                board[nextRow][nextCol] = 'B';
                            }
                        }
                    } else {
                        board[row][col] = (char) ('0' + mines);
                    }
                }
            }
            return board;
        }

        int getMines(char[][] board, int row, int col) {
            int count = 0;
            for (int[] d : dirs) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];
                if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length && (board[nextRow][nextCol] == 'M' || board[nextRow][nextCol] == 'X')) {
                    count++;
                }
            }
            return count;
        }
    }
}
