package LC.SOL;

import LC.DS.Point;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine {
    class Solution {
        public int maxPoints(int[][] points) {
            if ( points.length == 1 ) return 1;
            int max = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < points.length - 1; i++) {
                map.clear();
                int lineMax = 1, dup = 0;
                for (int j = i + 1; j < points.length; j++) {
                    int[] p1 = points[i], p2 = points[j];
                    if (Arrays.equals(p1 , p2)) {
                        dup++;continue;
                    }
                    int dy = p2[1] - p1[1] , dx = p2[0] - p1[0];
                    int gcd = gcd(dy , dx);
                    if ( gcd != 0  ) {
                        dy /= gcd; dx /= gcd;
                    }
                    String slope = dy + "/" + dx;
                    map.put(slope, map.getOrDefault(slope , 1 ) + 1);
                    lineMax = Math.max(lineMax, map.get(slope));
                }
                max = Math.max(max, lineMax + dup);
            }
            return max;
        }

        int gcd(int a, int b) {
            if (b == 0) return a;
            else return gcd(b, a % b);
        }
    }
}
