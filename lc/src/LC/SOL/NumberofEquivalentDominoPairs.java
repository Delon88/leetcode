package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class NumberofEquivalentDominoPairs {
    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            Map<Integer, Integer> map = new HashMap<>();
            int ret = 0;
            for (int[] d : dominoes) {
                int k = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
            for (int v : map.values()) {
                if (v > 1) ret += v * (v - 1) / 2;
            }
            return ret;
        }
    }
}
