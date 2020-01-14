package LC.SOL;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinaGridwithObstaclesElimination {
    class Solution {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        public int shortestPath(int[][] grid, int k) {
            int m = grid.length, n = grid[0].length;
            Queue<int[]> q = new LinkedList<>();
            int[][] dp = new int[m][n];
            int step = 0;
            for ( int[] d : dp ) Arrays.fill(d, Integer.MAX_VALUE);
            q.offer(new int[]{0 , 0 , 0});
            dp[0][0] = 0;
            while( !q.isEmpty()) {
                for ( int size = q.size(); size > 0 ; size--) {
                    int[] c = q.poll();
                    if ( c[0] == m - 1 && c[1] == n - 1) return step;
                    for (int[] d : dirs ) {
                        int x = c[0] + d[0], y = c[1] + d[1];
                        if ( x < 0 || x >= m || y < 0 || y >= n ) continue;
                        int obs = c[2] + grid[x][y];
                        if ( obs >= dp[x][y] || obs > k ) continue;
                        dp[x][y] = obs;
                        q.offer(new int[]{x, y , obs});
                    }
                }
                step++;
            }
            return -1;
        }
    }
}
