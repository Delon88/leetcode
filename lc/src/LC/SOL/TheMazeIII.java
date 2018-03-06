package LC.SOL;

import java.util.*;

public class TheMazeIII {
    static class Solution {
        int[][] dir = {{0, 1, 'r'}, {1, 0, 'd'}, {-1, 0, 'u'}, {0, -1, 'l'}};

        class Node {
            String path;
            int[] coor;
            int dist;

            public Node(String path, int[] coor, int dist) {
                this.path = path;
                this.coor = coor;
                this.dist = dist;
            }
        }

        public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
            if (Arrays.equals(ball, hole)) return "";
            PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.dist - b.dist);
            int[][] dp = new int[maze.length][maze[0].length];
            for ( int[] row : dp) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            q.add(new Node("", ball, 0));

            TreeSet<String> set = new TreeSet();
            int minDist = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
                Node node = q.poll();
                if (node.dist > dp[node.coor[0]][node.coor[1]]) continue;
                for (int[] d : dir) {
                    int nextX = node.coor[0] + d[0];
                    int nextY = node.coor[1] + d[1];
                    int dist = 0;
                    while (isValid(nextX, nextY, maze)) {
                        dist++;
                        if (nextX == hole[0] && nextY == hole[1]) {
                            if (dist + node.dist < minDist) {
                                minDist = dist + node.dist;
                                set = new TreeSet<>();
                                set.add(node.path + ((char) d[2]));
                            } else if (dist + node.dist == minDist) {
                                set.add(node.path + ((char) d[2]));
                            }
                        }
                        nextX = nextX + d[0];
                        nextY = nextY + d[1];
                    }
                    nextX -= d[0];
                    nextY -= d[1];
                    dp[nextX][nextY] = Math.min(node.dist + dist, dp[nextX][nextY]);
                    if ( nextX != node.coor[0] || nextY != node.coor[1]) {
                        q.add(new Node(node.path + ((char) d[2]), new int[]{nextX, nextY},
                                node.dist + dist));
                    }
                }
            }
            return set.isEmpty() ? "impossible" : set.first();
        }

        public boolean isValid(int x, int y, int[][] maze) {
            if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] maze = {{0, 1, 0, 0, 1, 0, 0, 1, 0, 0}, {0, 0, 1, 0, 0, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, {0, 1, 0, 0, 1, 0, 0, 1, 0, 0}, {0, 0, 1, 0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 1, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0, 1, 0}};
        printGrid(maze);
        int[] ball = {2, 4};
        int[] hold = {7, 6};
        System.out.println(new Solution().findShortestWay(maze, ball, hold));
    }

    public static void printGrid(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.printf("%5d ", a[i][j]);
            }
            System.out.println();
        }
    }
}
