package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            Set<String> set = new HashSet<>();
            for ( int[] ob : obstacles) { set.add(ob[0] + "," + ob[1]);}
            int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int d = 0, x = 0 , y = 0;
            int max = 0;
            for ( int c : commands) {
                if ( c == -2 ) {
                    d--;
                    if ( d == -1 ) d = 3;
                } else if ( c == -1) {
                    d++;
                    if ( d == 4) d =0;
                } else {
                    while ( c-- > 0 && !set.contains((x + dirs[d][0]) + "," + (y +dirs[d][1]))) {
                        x += dirs[d][0]; y += dirs[d][1];
                    }
                    max = Math.max(max , x * x + y * y);
                }
            }
            return max;
        }
    }
}
