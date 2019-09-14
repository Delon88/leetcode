package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GridIllumination {
    class Solution {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 0}};

        public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
            Map<Integer, Integer> xc = new HashMap<>();
            Map<Integer, Integer> yc = new HashMap<>();
            Map<Integer, Integer> di = new HashMap<>();
            Map<Integer, Integer> dd = new HashMap<>();
            Set<String> lset = new HashSet<>();
            for (int[] l : lamps) {
                int x = l[0], y = l[1];
                xc.put(x, xc.getOrDefault(x, 0) + 1);
                yc.put(y, yc.getOrDefault(y, 0) + 1);
                // y = x + c
                di.put(y - x, di.getOrDefault(y - x, 0) + 1);
                dd.put(y + x, dd.getOrDefault(y + x, 0) + 1);
                lset.add(x + "," + y);
            }

            int[] ret = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int x = queries[i][0], y = queries[i][1];
                if (xc.getOrDefault(x, 0) > 0 || yc.getOrDefault(y, 0) > 0 || di.getOrDefault(y - x, 0) > 0 || dd.getOrDefault(y + x, 0) > 0) {
                    ret[i] = 1;
                }
                for (int[] d : dirs) {
                    int x1 = x + d[0], y1 = y + d[1];
                    if (lset.contains(x1 + "," + y1)) {
                        xc.put(x1, xc.getOrDefault(x1, 1) - 1);
                        yc.put(y1, yc.getOrDefault(y1, 1) - 1);
                        di.put(y1 - x1, di.getOrDefault(y1 - x1, 1) - 1);
                        dd.put(y1 + x1, dd.getOrDefault(y1 + x1 , 1)  -1);
                        lset.remove(x1 + "," + y1);
                    }
                }
            }
            return ret;
        }
    }
}
