package LC.SOL;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheMazeII {
    public class Solution {
        class Point {
            int x, y, dist;

            public Point(int x, int y, int d) {
                this.x = x;
                this.y = y;
                this.dist = d;
            }
        }

        public int shortestDistance(int[][] maze, int[] start, int[] destination) {
            if (maze == null || maze.length == 0) return 0;
            int m = maze.length, n = maze[0].length;
            int[][] path = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    path[i][j] = Integer.MAX_VALUE;
                }
            }
            PriorityQueue<Point> q = new PriorityQueue<>((p1, p2) -> p1.dist - p2.dist);
            q.offer(new Point(start[0], start[1], 0));
            int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

            while (!q.isEmpty()) {
                Point node = q.poll();
                if (path[node.x][node.y] <= node.dist) continue;
                path[node.x][node.y] = node.dist;
                for (int[] d : dir) {
                    // roll ball
                    int x = node.x;
                    int y = node.y;
                    int dist = node.dist;
                    while (x + d[0] >= 0 && x + d[0] < m && y + d[1] >= 0 && y + d[1] < n && maze[x + d[0]][y + d[1]] == 0) {
                        x = x + d[0];
                        y = y + d[1];
                        dist++;
                    }

                    q.offer(new Point(x, y, dist));
                }
            }
            return path[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : path[destination[0]][destination[1]];
        }
    }
}
