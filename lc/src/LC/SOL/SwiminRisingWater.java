package LC.SOL;

import java.util.PriorityQueue;

public class SwiminRisingWater {
    class Solution {
        public int swimInWater(int[][] grid) {
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            q.offer(new int[]{0, 0, grid[0][0]});
            boolean[][] v = new boolean[grid.length][grid[0].length];
            int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            while (!q.isEmpty()) {
                int[] node = q.poll();
                if ( node[0] == grid.length - 1 && node[1] == grid[0].length - 1) return node[2];
                v[node[0]][node[1]] = true;
                for (int[] d : dirs) {
                    int nextX = node[0] + d[0];
                    int nextY = node[1] + d[1];
                    if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && !v[nextX][nextY]) {
                        q.offer(new int[]{nextX, nextY, Math.max(grid[nextX][nextY], node[2])});
                    }
                }
            }
            return 0;
        }
    }
}
