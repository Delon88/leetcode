package LC.SOL;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesandLadders {
    class Solution {
        public int snakesAndLadders(int[][] board) {
            Queue<Integer> q = new LinkedList<>();
            int n = board.length;
            q.offer(1);
            int step = 0;
            boolean[] v = new boolean[n * n + 1];
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int node = q.poll();
                    if ( v[node] ) continue;
                    v[node] = true;
                    if (node == n * n) return step;
                    for (int k = 1; k <= 6 && node + k <= n * n; k++) {
                        int next = k + node;
                        int value = getBoardVaule(board,next);
                        if ( value > 0) next = value;
                        if ( !v[next]) {
                            q.offer(next);
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        private int getBoardVaule(int[][] board, int num) {
            int n = board.length;
            int row = (num - 1) / n;
            int col = (num - 1) % n;
            int x = n - 1 - row;
            int y = row % 2 == 0 ? col : n - col - 1;
            return board[x][y];
        }
    }
}
