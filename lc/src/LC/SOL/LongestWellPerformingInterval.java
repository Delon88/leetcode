package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformingInterval {
    class Solution {
        public int longestWPI(int[] hours) {
            int s = 0, max = 0, n = hours.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                s += hours[i] > 8 ? 1 : -1;
                if (s > 0) {
                    max = i + 1;
                } else {
                    map.putIfAbsent(s, i);
                    if (map.containsKey(s - 1)) {
                        max = Math.max(max, i - map.get(s - 1));
                    }
                }
            }
            return max;
        }
    }
}
