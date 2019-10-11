package LC.SOL;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLandasPossible {
    class Solution {
        public int maxDistance(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) q.offer(new int[]{i, j});
                }
            }
            if (q.isEmpty() || q.size() == m * n) return -1;
            int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            int max = 0;
            while (!q.isEmpty()) {
                for (int size = q.size(); size > 0; size--) {
                    int[] cur = q.poll();
                    for ( int[] d : dirs) {
                        int x = cur[0] + d[0], y = cur[1] + d[1];
                        if ( x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                            grid[x][y] = 1;
                            q.offer(new int[]{x ,y});
                        }
                    }
                }
                max++;
            }
            return max - 1;
        }
    }
}
