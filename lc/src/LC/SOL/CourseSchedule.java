package LC.SOL;

import java.util.*;

public class CourseSchedule {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for ( int i = 0 ;i < numCourses; i++) {
                graph.put(i, new HashSet<>());
            }
            for (int[] p : prerequisites) {
                graph.get(p[1]).add(p[0]);
            }
            int[] v = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                if (v[i] == 0 && !dfs(graph, v, i)) return false;
            }
            return true;
        }

        boolean dfs(Map<Integer, Set<Integer>> graph, int[] v, int node) {
            if (v[node] == 2) return true;
            if (v[node] == 1) return false;
            v[node] = 1;
            for (Integer nei : graph.get(node)) {
                if (!dfs(graph, v, nei)) return false;
            }
            v[node] = 2;
            return true;
        }
    }


    class Point {
        int x , y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private final char SEA = '0';
    private final char ISLAND = '1';

    int row;
    int col;

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    // return number of islands
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        row = grid.length;
        col = grid[0].length;

        int number = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == ISLAND) {
                    traverse(grid, i, j);
                    number++;
                }
            }
        }

        return number;
    }

    private void traverse(char[][] grid, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        grid[x][y] = SEA;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                Point adj = new Point(cur.x + dx[i], cur.y + dy[i]);

                if (canMove(grid, adj)) {
                    queue.offer(adj);
                    grid[adj.x][adj.y] = SEA;
                }
            }
        }
    }

    private boolean canMove(char[][] grid, Point adj) {
        return 0 <= adj.x && adj.x < row && 0 <= adj.y && adj.y < col && grid[adj.x][adj.y] == ISLAND;
    }

}
