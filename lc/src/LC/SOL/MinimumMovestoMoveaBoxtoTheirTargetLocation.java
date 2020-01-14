package LC.SOL;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumMovestoMoveaBoxtoTheirTargetLocation {
    class Solution {
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        public int minPushBox(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[] start = new int[2], target = new int[2], box = new int[2];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char ch = grid[i][j];
                    if (ch == 'T') {
                        target = new int[]{i, j};
                    }
                    if (ch == 'S') {
                        start = new int[]{i, j};
                    }
                    if (ch == 'B') {
                        box = new int[]{i, j};
                    }
                }
            }
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
            q.offer(new int[]{dist(box[0], box[1], target[0], target[1]), 0, start[0], start[1], box[0], box[1]});
            Set<String> set = new HashSet<>();
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int moves = cur[1];
                int sx = cur[2], sy = cur[3];
                int bx = cur[4], by = cur[5];
                if (bx == target[0] && by == target[1]) return moves;
                String ss = sx + ":" + sy + "|" + bx + ":" + by;
                if (!set.add(ss)) continue;
                for ( int[] d: dirs) {
                    int nx = sx + d[0], ny = sy + d[1];
                    if ( !valid(nx , ny, m , n , grid)) continue;
                    int[] next;
                    if (nx == bx && ny == by) {
                        int nbx = bx + d[0], nby = by + d[1];
                        if ( !valid(nbx, nby, m, n , grid)) continue;
                        next = new int[]{dist(nbx, nby, target[0], target[1])+moves+1, moves+1, nx, ny, nbx, nby};
                    } else {
                        next = new int[]{cur[0], moves, nx, ny, bx, by};
                    }
                    q.offer(next);
                }
            }
            return -1;
        }

        private boolean valid(int x, int y, int m, int n, char[][] g) {
            if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || g[x][y] == '#') return false;
            return true;
        }

        private int dist(int x, int y, int tx, int ty) {
            return Math.abs(x - tx) + Math.abs(y - ty);
        }
    }
}
