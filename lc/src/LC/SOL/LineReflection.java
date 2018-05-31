package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class LineReflection {
    class Solution {
        public boolean isReflected(int[][] points) {
            if ( points == null || points.length == 0 ) return true;
            int max = points[0][0], min = points[0][0];
            Set<String> set = new HashSet<>();
            for ( int[] p : points) {
                min = Math.min(min, p[0]);
                max = Math.max( max, p[0]);
                set.add(p[0] + "," + p[1]);
            }
            int sum = min + max;
            for( int[] p : points) {
                if ( !set.contains( ( sum - p[0]) + "," + p[1])) return false;
            }
            return true;
        }
    }
}
