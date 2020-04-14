package LC.SOL;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumCandiesYouCanGetfromBoxes {
    class Solution {
        public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
            int n = status.length;
            boolean[] usedBox = new boolean[n];
            boolean[] foundBox = new boolean[n];
            int ret = 0;
            Queue<Integer> q = new LinkedList<>();
            for ( int i : initialBoxes) {
                if ( status[i] == 1) q.offer(i);
                foundBox[i] = true;
            }
            while ( !q.isEmpty()) {
                int cur = q.poll();
                if ( status[cur] == 1 && !usedBox[cur]) {
                    ret += candies[cur];
                    usedBox[cur] = true;
                    for ( int key : keys[cur]) {
                        status[key] = 1;
                        if ( foundBox[key] ) q.offer(key);
                    }
                    for ( int b : containedBoxes[cur]) {
                        foundBox[b] = true;
                        q.offer(b);
                    }
                }
            }
            return ret;
        }
    }
}
