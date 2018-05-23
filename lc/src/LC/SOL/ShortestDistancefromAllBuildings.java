package LC.SOL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistancefromAllBuildings {

    //    You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
//    You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
//
//    Each 0 marks an empty land which you can pass by freely.
//    Each 1 marks a building which you cannot pass through.
//    Each 2 marks an obstacle which you cannot pass through.
//    Example:
//
//    Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
//
//            1 - 0 - 2 - 0 - 1
//            |   |   |   |   |
//            0 - 0 - 0 - 0 - 0
//            |   |   |   |   |
//            0 - 0 - 1 - 0 - 0
//
//    Output: 7
//
//    Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
//    the point (1,2) is an ideal empty land to build a house, as the total
//    travel distance of 3+3+1=7 is minimal. So return 7.
    class Solution {
        int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        public int shortestDistance(int[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int m = grid.length, n = grid[0].length;
            int[][] dist = new int[m][n];
            int[][] reach = new int[m][n];
            int numBuilding = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        numBuilding++;
                        bfs(grid, dist, reach, i, j);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (reach[i][j] == numBuilding) {
                        min = Math.min(dist[i][j] , min);
                    }
                }
            }
            return min == Integer.MAX_VALUE ? -1: min;
        }

        void bfs(int[][] grid, int[][] dist, int[][] reach, int x, int y) {
            Queue<int[]> q = new LinkedList<>();
            int m = dist.length, n = dist[0].length;
            boolean[][] v = new boolean[m][n];
            v[x][y] = true;
            q.offer(new int[]{x, y});
            int level = 0;
            while (!q.isEmpty()) {
                level++;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] node = q.poll();
                    for (int[] d : dirs) {
                        int nextX = node[0] + d[0], nextY = node[1] + d[1];
                        if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 0 && !v[nextX][nextY]) {
                            dist[nextX][nextY] += level;
                            reach[nextX][nextY]++;
                            v[nextX][nextY] = true;
                            q.offer(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }
    }
}
