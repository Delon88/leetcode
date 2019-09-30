package LC.SOL;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
    class Solution {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
            Queue<int[]> q = new LinkedList<>();
            boolean[][] v = new boolean[n][n];
            v[0][0] = true;
            q.offer(new int[]{0, 0});
            int ret = 0;
            while (!q.isEmpty()) {
                ret++;
                for (int size = q.size(); size > 0; size--) {
                    int[] node = q.poll();
                    if (node[0] == n - 1 && node[1] == n - 1) return ret;
                    for (int[] d : dirs) {
                        int X = node[0] + d[0], Y = node[1] + d[1];
                        if (X >= 0 && X < n && Y >= 0 && Y < n && grid[X][Y] != 1 && !v[X][Y]) {
                            v[X][Y] = true;
                            q.offer(new int[]{X, Y});
                        }
                    }
                }
            }
            return -1;
        }
    }
}
