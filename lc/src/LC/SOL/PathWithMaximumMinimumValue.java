package LC.SOL;

import java.util.PriorityQueue;

public class PathWithMaximumMinimumValue {
    class Solution {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int maximumMinimumPath(int[][] A) {
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            int m = A.length, n = A[0].length;
            boolean[][] v = new boolean[m][n];
            v[0][0] = true;
            q.offer(new int[]{A[0][0], 0, 0});
            while ( !q.isEmpty()) {
                int[] cur = q.poll();
                if ( cur[1] == m - 1 && cur[2] == n - 1) return cur[0];
                for ( int[] d : dirs) {
                    int x = cur[1] + d[0], y = cur[2] + d[1];
                    if ( x >= 0 && x < m && y >=0 && y < n && !v[x][y] ) {
                        v[x][y] = true;
                        q.offer(new int[]{Math.min(cur[0], A[x][y]), x , y});
                    }
                }
            }
            return -1;
        }
    }
}
