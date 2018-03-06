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
            Queue<Node> q = new LinkedList<>();
            q.add(new Node("", ball, 0));
            Set<String> v = new HashSet<>();
            TreeSet<String> set = new TreeSet();
            int minDist = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
                Node node = q.poll();
                v.add(node.coor[0] + "," + node.coor[1]);
                for (int[] d : dir) {
                    int nextX = node.coor[0] + d[0];
                    int nextY = node.coor[1] + d[1];
                    int dist = 0;
                    while (isValid(nextX, nextY, maze)) {
                        dist++;
                        if (nextX == hole[0] && nextY == hole[1]) {
                            if ( dist + node.dist < minDist ) {
                                minDist = dist + node.dist;
                                set = new TreeSet<>();
                                set.add(node.path + ((char) d[2]));
                            } else if ( dist + node.dist == minDist) {
                                set.add(node.path + ((char) d[2]));
                            }
                        }
                        nextX = nextX + d[0];
                        nextY = nextY + d[1];
                    }
                    nextX -= d[0];
                    nextY -= d[1];
                    if (!v.contains(nextX + "," + nextY)) {
                        q.add(new Node(node.path + ((char) d[2]), new int[]{nextX, nextY},
                                node.dist + dist));
                    }
                }
            }
            System.out.println(set);
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
        int[][] maze = {
                {0, 0, 0, 0, 0}, {
                1, 1, 0, 0, 1
        }, {
                0, 0, 0, 0, 0
        }, {
                0, 1, 0, 0, 1
        }, {
                0, 1, 0, 0, 0
        }};
        int[] ball = {4, 3};
        int[] hole = {0, 1};
        System.out.println(new Solution().findShortestWay(maze, ball, hole));
    }
}
