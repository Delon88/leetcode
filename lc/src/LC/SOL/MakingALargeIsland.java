package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {
    class Solution {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int largestIsland(int[][] grid) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 0);
            int curColor = 2;
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int[] count = {0};
                        dfs(grid, curColor, i, j, count);
                        map.put(curColor, count[0]);
                        curColor++;
                    }
                }
            }
            int max = map.getOrDefault(2, 0);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        int tmp = 1;
                        Set<Integer> set = new HashSet<>();
                        for (int[] d : dirs) {
                            int nextI = i + d[0], nextJ = j + d[1];
                            if ( nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n ) {
                                set.add(grid[nextI][nextJ]);
                            }
                        }
                        for ( int c : set) tmp += map.get(c);
                        max = Math.max(max, tmp);
                    }
                }
            }
            return max;
        }

        void dfs(int[][] grid, int color, int x, int y, int[] count) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) return;
            grid[x][y] = color;
            count[0]++;
            for (int[] d : dirs) {
                int nextX = x + d[0], nextY = y + d[1];
                dfs(grid, color, nextX, nextY, count);
            }
        }
    }
}
