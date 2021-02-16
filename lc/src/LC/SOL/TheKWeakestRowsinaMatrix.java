package LC.SOL;

import java.util.PriorityQueue;

public class TheKWeakestRowsinaMatrix {
    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
                if (b[0] == a[0])
                    return b[1] - a[1];
                else
                    return b[0] - a[0];
            });
            int m = mat.length, n = mat[0].length;
            for (int i = 0; i < m; i++) {
                int sol = 0;
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1)
                        sol++;
                }
                q.offer(new int[] { sol, i });
                if (q.size() > k)
                    q.poll();
            }
            int[] ret = new int[k];
            int i = k - 1;
            while (!q.isEmpty()) {
                ret[i] = q.poll()[1];
                i--;
            }
            return ret;
        }
    }
}
