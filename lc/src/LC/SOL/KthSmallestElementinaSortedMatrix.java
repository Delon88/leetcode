package LC.SOL;

import java.util.PriorityQueue;

/**
 * Created by nanhong on 12/11/2016.
 */
public class KthSmallestElementinaSortedMatrix {
    public static class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            PriorityQueue<int[]> q = new PriorityQueue<>(n, (a, b) -> {
                return Integer.valueOf(a[2]).compareTo(b[2]);
            });

            for (int i = 0; i < n; i++) q.offer(new int[]{0, i, matrix[0][i]});
            for (int i = 0; i < k - 1; i++) {
                int[] t = q.poll();
                if (t[1] == n - 1) continue;
                q.offer(new int[]{t[1] + 1, t[2], matrix[t[1] + 1][t[2]]});
            }
            return q.poll()[0];
        }
    }
}
