package LC.SOL;

import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.valueOf(b[0] * b[0] + b[1] * b[1]).compareTo(a[0] * a[0] + a[1] * a[1]));
            for (int[] p : points) {
                q.offer(p);
                if ( q.size() > K ) q.poll();
            }
            int[][] ret = new int[K][2];
            while ( !q.isEmpty()) ret[--K] = q.poll();
            return ret;
        }
    }
}
