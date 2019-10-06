package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {
    class Solution {
        public int largestUniqueNumber(int[] A) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int a : A) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
            int ret = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue() == 1) {
                    ret = Math.max(ret, e.getKey());
                }
            }
            return ret == Integer.MIN_VALUE ? -1 : ret;
        }
    }
}
