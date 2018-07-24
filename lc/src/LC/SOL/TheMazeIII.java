package LC.SOL;

import java.util.*;

public class TheMazeIII {
    class Solution {
        class Solution {
            int[][] dirs = {{1, 0, 'd'}, {0, 1, 'r'}, {-1, 0, 'u'}, {0, -1, 'l'}};

            class Node implements Comparable<Node> {
                public int dist;
                public String path;
                public int x;
                public int y;

                public Node(int x, int y, int dist, String path) {
                    this.dist = dist;
                    this.path = path;
                    this.x = x;
                    this.y = y;
                }

                public Node(int x, int y) {
                    this.dist = Integer.MAX_VALUE;
                    path = "";
                    this.x = x;
                    this.y = y;
                }

                public int compareTo(Node n) {
                    return n.dist == this.dist ? path.compareTo(n.path) : dist - n.dist;
                }
            }

            public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
                if (Arrays.equals(ball, hole)) return "";
                PriorityQueue<Node> q = new PriorityQueue<>();
                int m = maze.length, n = maze[0].length;
                q.offer(new Node(ball[0], ball[1], 0, ""));
                Node[][] nodes = new Node[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        nodes[i][j] = new Node(i, j);
                    }
                }
                while (!q.isEmpty()) {
                    Node node = q.poll();
                    if ( nodes[node.x][node.y].compareTo(node) <= 0 ) continue;
                    nodes[node.x][node.y] = node;
                    for (int[] d : dirs) {
                        int x = node.x, y = node.y;
                        int dist = 0;
                        while (x >= 0 && x  < m && y  >= 0 && y < n && maze[x][y] == 0 && (x != hole[0] || y != hole[1]) ) {
                            dist++;
                            x = x + d[0];
                            y = y + d[1];
                        }
                        if ( x != hole[0] || y != hole[1]) {
                            x -= d[0];
                            y -= d[1];
                            dist--;
                        }
                        q.offer(new Node(x, y, node.dist + dist, node.path + ((char) d[2])));
                    }
                }
                return nodes[hole[0]][hole[1]].dist == Integer.MAX_VALUE ? "impossible" : nodes[hole[0]][hole[1]].path;
            }
        }

}
