package LC.SOL;

import java.util.*;

public class NumberofDistinctIslands {
    class Solution {

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public int numDistinctIslands(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            boolean[][] v = new boolean[m][n];
            Set<List<List<Integer>>> set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!v[i][j] && grid[i][j] == 1) {
                        List<List<Integer>> isLand = new ArrayList<>();
                        dfs(i, j, i, j, grid, v, isLand);
                        set.add(isLand);
                    }
                }
            }
            return set.size();
        }

        void dfs(int ox, int oy, int x, int y, int[][] grid, boolean[][] v, List<List<Integer>> isLand) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1 || v[x][y]) return;
            v[x][y] = true;
            isLand.add(Arrays.asList(x - ox, y - oy));
            for (int[] d : dirs) {
                int nextX = x + d[0];
                int nextY = y + d[1];
                dfs(ox, oy, nextX, nextY, grid, v, isLand);
            }
        }
    }
}
