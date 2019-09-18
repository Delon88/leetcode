package LC.SOL;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixCellsinDistanceOrder {
    class Solution {
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{r0, c0});
            int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            boolean[][] v = new boolean[R][C];
            v[r0][c0] = true;
            int[][] ret = new int[R * C][2];
            int i = 0;
            while (!q.isEmpty()) {
                for (int size = q.size(); size > 0; size--) {
                    int[] node = q.poll();
                    ret[i++] = node;
                    for (int[] d : dirs) {
                        int nextX = node[0] + d[0], nextY = node[1] + d[1];
                        if ( nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && !v[nextX][nextY]) {
                            v[nextX][nextY] = true;
                            q.offer(new int[]{nextX, nextY});
                        }
                    }
                }
            }
            return ret;
        }
    }
}
