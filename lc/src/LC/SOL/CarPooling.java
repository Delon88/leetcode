package LC.SOL;

import java.util.Arrays;

public class CarPooling {
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[][] ts = new int[trips.length * 2][2];
            for (int i = 0; i < trips.length; i++) {
                ts[2 * i] = new int[]{trips[i][1], trips[i][0]};
                ts[2 * i + 1] = new int[]{trips[i][2], -trips[i][0]};
            }
            Arrays.sort(ts, (t1, t2) -> {if (t1[0] == t2[0]) return t1[1] - t2[1];else return t1[0] - t2[0];});
            int curC = 0;
            for ( int[] t : ts ) {
                curC += t[1];
                if ( curC > capacity) return false;
            }
            return curC <= capacity;
        }
    }
}
