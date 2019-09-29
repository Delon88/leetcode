package LC.SOL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberofEqualRows {
    class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            Map<String, Integer> map = new HashMap<>();
            for (int[] r : matrix) {
                String key1 = Arrays.toString(r);
                int[] c = r.clone();
                for (int i = 0; i < c.length; i++) c[i] = 1 - c[i];
                String key2 = Arrays.toString(c);
                map.put(key1, map.getOrDefault(key1, 0) + 1);
                map.put(key2, map.getOrDefault(key2, 0) + 1);
            }
            int ret =0;
            for ( int v: map.values()) ret = Math.max(ret ,v );
            return ret;
        }
    }
}
