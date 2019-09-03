package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumAreaRectangleII {
    class Solution {
        public double minAreaFreeRect(int[][] points) {
            int n = points.length;
            Map<String, List<int[]>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int dist = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                    double centerX = (double) (points[i][0] + points[j][0]) / 2, centerY = (double) (points[i][1] + points[j][1]) / 2;
                    String key = dist + "," + centerX + "," + centerY;
                    if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                    map.get(key).add(new int[]{i, j});
                }
            }
            double ret = Double.MAX_VALUE;
            for (String key : map.keySet()) {
                List<int[]> cands = map.get(key);
                if (cands.size() > 1) {
                    for (int i = 0; i < cands.size(); i++) {
                        for (int j = i + 1; j < cands.size(); j++) {
                            int[] p1 = points[cands.get(i)[0]], p2 = points[cands.get(j)[0]], p3 = points[cands.get(j)[1]];
                            double len1 = Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
                            double len2 = Math.sqrt((p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]));
                            double area = len1 * len2;
                            ret = Math.min(ret, area);
                        }
                    }
                }
            }
            return ret == Double.MAX_VALUE ? 0.0 : ret;
        }
    }
}
