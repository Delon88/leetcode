package LC.SOL;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    class Solution {

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int shortestBridge(int[][] A) {
            int m = A.length , n = A[0].length;
            Queue<int[]> q = new LinkedList<>();
            boolean[][] v = new boolean[m][n];
            outter:
            for ( int i = 0 ; i < m ; i++) for (int j = 0 ; j < n ; j++) {
                if ( A[i][j] == 1) {
                    dfs(A , v , i , j , q);
                    break outter;
                }
            }
            // bfs find another island
            int step = 0;
            while ( !q.isEmpty()) {
                for ( int size = q.size() ; size > 0 ; size--) {
                    int[] node = q.poll();
                    for ( int[] d : dirs ) {
                        int i = node[0] + d[0], j = node[1] + d[1];
                        if ( i >= 0 && j >= 0 && i < m && j < n && !v[i][j]) {
                            if ( A[i][j] == 1 ) return step;
                            v[i][j] = true;
                            q.offer(new int[]{i , j });
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        void dfs(int[][] A, boolean[][] v, int x, int y, Queue<int[]> q) {
            if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || v[x][y] || A[x][y] != 1) return;
            v[x][y] = true;
            q.offer(new int[]{x, y});
            for (int[] d : dirs) {
                dfs(A, v, x + d[0], y + d[1], q);
            }
        }
    }
}
