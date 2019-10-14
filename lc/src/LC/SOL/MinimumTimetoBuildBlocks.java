package LC.SOL;

import java.util.PriorityQueue;

public class MinimumTimetoBuildBlocks {
    class Solution {
        public int minBuildTime(int[] blocks, int split) {
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for ( int b : blocks) q.offer(b);
            while ( q.size() > 1 ) {
                int x = q.poll(), y = q.poll();
                q.offer( y + split);
            }
            return q.poll();
        }
    }
}
