package LC.SOL;

import java.util.*;

public class SlidingPuzzle {
    class Solution {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        class Node {
            int[][] a;
            int i;
            int j;

            public Node(int[][] a, int i, int j) {
                this.a = a;
                this.i = i;
                this.j = j;
            }
        }

        public int slidingPuzzle(int[][] board) {
            int[][] end = {{1, 2, 3}, {4, 5, 0}};
            String boardStr = toString(board);
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(end, 1, 2));
            Set<String> set = new HashSet<>();
            int number = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int k = 0; k < size; k++) {
                    Node node = q.poll();
                    if (toString(node.a).equals(boardStr)) return number;
                    // iterate all possible swap;
                    int[][] a = node.a;
                    for (int[] d : dirs) {
                        int nextX = node.i + d[0];
                        int nextY = node.j + d[1];
                        if (nextX >= 0 && nextX < a.length && nextY >= 0 && nextY < a[0].length) {
                            int[][] nextA = deepCopy(a);
                            int tmp = a[nextX][nextY];
                            nextA[nextX][nextY] = a[node.i][node.j];
                            nextA[node.i][node.j] = tmp;
                            String nextAStr = toString(nextA);
                            if (!set.contains(nextAStr)) {
                                set.add(nextAStr);
                                q.add(new Node(nextA, nextX, nextY));
                            }
                        }
                    }
                }
                number++;
            }
            return -1;
        }

        String toString(int[][] a) {
            StringBuilder b = new StringBuilder();
            for (int[] e : a) {
                b.append(Arrays.toString(e));
            }
            return b.toString();
        }

        int[][] deepCopy(int[][] a) {
            int[][] ret = new int[a.length][a[0].length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    ret[i][j] = a[i][j];
                }
            }
            return ret;
        }
    }
}
