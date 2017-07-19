package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class NumberofBoomerangs {
    public class Solution {
        public int numberOfBoomerangs(int[][] points) {

            int ret = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points.length; j++) {
                    if (i == j) continue;
                    int dist = getDist(points[i], points[j]);
                    map.put(dist, map.getOrDefault(dist, 0) + 1);
                }

                for (int val : map.values()) {
                    if (val >= 2) {
                        ret += val * (val - 1);
                    }
                }
                map.clear();
            }
            return ret;
        }

        private int getDist(int[] i, int[] j) {
            int dx = i[0] - j[0];
            int dy = i[1] - j[1];
            return dx * dx + dy * dy;
        }
    }
}
