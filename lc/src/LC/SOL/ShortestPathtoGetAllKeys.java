package LC.SOL;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathtoGetAllKeys {
    class Solution {

        class Node {
            int x, y, key;

            public Node(int x, int y, int key) {
                this.x = x;
                this.y = y;
                this.key = key;
            }
        }

        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        public int shortestPathAllKeys(String[] grid) {

            int x = -1, y = -1, maxKeys = 0, m = grid.length, n = grid[0].length();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length(); j++) {
                    char c = grid[i].charAt(j);
                    if (c == '@') {
                        x = i;
                        y = j;
                    } else if (c >= 'a' && c <= 'f') {
                        maxKeys = Math.max(maxKeys, c - 'a' + 1);
                    }
                }
            }
            Set<String> vi = new HashSet<>();
            Queue<Node> q = new LinkedList<>();
            Node start = new Node(x, y, 0);
            q.offer(start);
            vi.add(x + " " + y + " " + 0);
            int allKeys = (1 << maxKeys) - 1;
            int ret = 0;
            while (!q.isEmpty()) {
                for (int size = q.size(); size > 0; size--) {
                    Node node = q.poll();
                    if (node.key == allKeys) return ret;
                    for (int[] d : dirs) {
                        int nextX = node.x + d[0], nextY = node.y + d[1], keys = node.key;
                        if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                            char c = grid[nextX].charAt(nextY);
                            if (c == '#') continue;
                            if (c >= 'a' && c <= 'f') {
                                keys |= 1 << (c - 'a');
                            } else if (c >= 'A' && c <= 'F' && (((keys >> (c - 'a')) & 1) == 0)) {
                                continue;
                            }
                            if ( vi.add(nextX +  " " + nextY + " " + keys)) {
                                q.offer(new Node( nextX , nextY , keys));
                            }
                        }
                    }
                }
                ret++;
            }
            return -1;
        }
    }
}
