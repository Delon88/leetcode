package LC.SOL;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    public class Solution {

        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            if (maze == null || maze.length == 0) return false;
            if (Arrays.equals(start, destination)) return true;
            int m = maze.length, n = maze[0].length;
            Queue<int[]> q = new LinkedList<>();
            q.offer(start);
            int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

            boolean[][] v = new boolean[m][n];
            v[start[0]][start[1]] = true;
            while (!q.isEmpty()) {
                int[] node = q.poll();
                for (int[] d : dir) {
                    // roll ball
                    int x = node[0];
                    int y = node[1];
                    while (x + d[0] >= 0 && x + d[0] < m && y + d[1] >= 0 && y + d[1] < n && maze[x + d[0]][y + d[1]] == 0) {
                        x = x + d[0];
                        y = y + d[1];
                    }
                    if ( v[x][y] ) continue;
                    v[x][y] = true;
                    if ( destination[0] == x && destination[1] == y) return true;
                    q.offer(new int[]{x ,y});
                }
            }
            return false;
        }
    }
}
