package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CampusBikes {
    class Solution {
        public int[] assignBikes(int[][] workers, int[][] bikes) {
            List<int[]>[] buckets = new ArrayList[2001];
            for (int i = 0; i < workers.length; i++) {
                for (int j = 0; j < bikes.length; j++) {
                    int dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                    if (buckets[dist] == null) buckets[dist] = new ArrayList<>();
                    buckets[dist].add(new int[]{i, j});
                }
            }
            boolean[] bv = new boolean[bikes.length];
            int[] ret = new int[workers.length];
            Arrays.fill(ret, -1);
            for (int d = 0; d < buckets.length; d++) {
                if (buckets[d] == null) continue;
                for (int i = 0; i < buckets[d].size(); i++) {
                    int w = buckets[d].get(i)[0], b = buckets[d].get(i)[1];
                    if ( bv[b] || ret[w] != -1) continue;
                    bv[b] = true; ret[w] = b;
                }
            }
            return ret;
        }
    }
}
