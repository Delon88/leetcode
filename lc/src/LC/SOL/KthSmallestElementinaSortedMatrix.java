package LC.SOL;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {
    public static class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            PriorityQueue<int[]> q = new PriorityQueue<>((a ,b) -> a[2] - b[2]);
            for ( int i = 0 ; i < n ; i++) {
                q.offer(new int[]{i , 0, matrix[i][0]});
            }
            for ( int i = 0 ; i < k - 1 ; i++) {
                int[] node = q.poll();
                if ( node[1] + 1< n ) {
                    q.offer(new int[]{node[0], node[1]+ 1, matrix[node[0]][node[1] + 1]});
                }
            }
            return q.peek()[2];
        }
    }
}
