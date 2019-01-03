package LC.SOL;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarraywithSumatLeastK {
    class Solution {
        public int shortestSubarray(int[] A, int K) {
            int n = A.length;
            int[] cumu = new int[n + 1];
            for ( int i = 0 ; i < n ; i++) cumu[i + 1] = cumu[i] + A[i];
            Deque<Integer> q = new LinkedList<>();
            int ret = n + 1;
            for ( int i = 0 ; i < n + 1 ; i++) {
                while ( q.size() > 0 && cumu[i] - cumu[q.getFirst()] >= K ) {
                    ret = Math.min(ret, i - q.pollFirst());
                }
                while ( q.size() > 0 && cumu[i] <= cumu[q.getLast()] ) {
                    q.pollLast();
                }
                q.addLast(i);
            }
            return ret <= n ? ret : -1;
        }
    }
}
