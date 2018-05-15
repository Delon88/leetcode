package LC.SOL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {
    class Solution {
        public List<int[]> getSkyline(int[][] buildings) {
            List<int[]> heights = new ArrayList<>();
            for ( int[] b : buildings) {
                heights.add(new int[]{ b[0], -b[2]});
                heights.add(new int[]{ b[1] , b[2]});
            }
            Collections.sort(heights, (a , b) -> { if ( a[0] != b[0] ) return a[0] - b[0];else return a[1] - b[1];});
            PriorityQueue<Integer> q = new PriorityQueue<>((a , b) -> b - a);
            q.offer(0);
            int prev = 0;
            List<int[]> ret = new ArrayList<>();
            for ( int[] h : heights) {
                if ( h[1] < 0 ) {
                    q.offer(-h[1]);
                } else {
                    q.remove(h[1]);
                }
                int cur = q.peek();
                if ( cur != prev ) {
                    ret.add(new int[]{h[0], cur});
                    prev = cur;
                }
            }
            return ret;
        }
    }
}
