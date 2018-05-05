package LC.SOL;

import LC.DS.Point;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine {
    class Solution {
        public int maxPoints(Point[] points) {
            if ( points.length == 1) return 1;
            int max = 0 ;
            Map<String,Integer> map = new HashMap<>();
            for ( int i = 0 ; i < points.length - 1 ; i++) {
                // slope -> number of points
                map.clear();
                int dup = 0;
                int lineMax = 1;
                for ( int j = i + 1 ; j < points.length; j++) {
                    Point p1 = points[i], p2 = points[j];
                    if ( p1.x == p2.x && p1.y == p2.y) {
                        dup++;continue;
                    }
                    int dx = p2.x - p1.x;
                    int dy = p2.y - p1.y;
                    int gcd = gcd(dx , dy);
                    if ( gcd != 0 ) {
                         dx = dx / gcd; dy = dy / gcd;
                    }
                    String slope = dx + "_" + dy;
                    map.put(slope, map.getOrDefault(slope, 1) + 1);
                    lineMax = Math.max(lineMax, map.get(slope));
                }
                max = Math.max(max, lineMax + dup);
            }
            return max;
        }

        int gcd( int a , int b) {
            if ( b == 0 ) return a;
            else return gcd(b, a % b);
        }
    }
}
