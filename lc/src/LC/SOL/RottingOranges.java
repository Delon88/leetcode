package LC.SOL;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    class Solution {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int orangesRotting(int[][] grid) {
            int m = grid.length, n = grid[0].length, fresh = 0 ;
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) q.offer(new int[]{i, j});
                    else if ( grid[i][j] == 1) fresh++;
                }
            if ( fresh == 0) return 0;
            int ret = 0;
            while (!q.isEmpty()) {
                for (int size = q.size(); size > 0; size--) {
                    int[] node = q.poll();
                    for (int[] d : dirs) {
                        int nextX = node[0] + d[0], nextY = node[1] + d[1];
                        if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1) {
                            fresh--;
                            q.offer(new int[]{nextX, nextY});
                            grid[nextX][nextY] = 2;
                        }
                    }
                }
                ret++;
            }
            return fresh == 0 ? ret - 1: -1;
        }
    }
}
