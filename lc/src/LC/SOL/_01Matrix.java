package LC.SOL;


import java.util.LinkedList;
import java.util.Queue;

public class _01Matrix {
    class Solution {

        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        public int[][] updateMatrix(int[][] matrix) {

            int m = matrix.length, n = matrix[0].length;
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) q.offer(new int[]{i, j});
                    else matrix[i][j] = Integer.MAX_VALUE;
                }
            }

            while (!q.isEmpty()) {
                int[] node = q.poll();
                int i = node[0], j = node[1];
                // try next
                for (int[] d : dir) {
                    int di = d[0] + i;
                    int dj = d[1] + j;
                    if (di < 0 || di >= m || dj < 0 || dj >= n || matrix[di][dj] <= matrix[i][j] + 1) continue;
                    q.offer(new int[]{di, dj});
                    matrix[di][dj] = matrix[i][j] + 1;
                }
            }
            return matrix;
        }
    }


}
