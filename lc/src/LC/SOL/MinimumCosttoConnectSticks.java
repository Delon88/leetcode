package LC.SOL;

import java.util.PriorityQueue;

public class MinimumCosttoConnectSticks {
    class Solution {
        public int connectSticks(int[] sticks) {
            PriorityQueue<Integer> q = new PriorityQueue<>();
            int ret = 0;
            for ( int s : sticks) q.offer(s);
            while ( q.size() > 1 ) {
                int cost = q.poll() + q.poll();
                ret += cost;
                q.offer(cost);
            }
            return ret;
        }
    }
}
