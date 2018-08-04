package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    class Solution {
        public int findLHS(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }

            int maxLen = 0;
            for (Integer n : map.keySet()) {
                if (map.containsKey(n + 1)) {
                    maxLen = Math.max(map.get(n) + map.get(n + 1), maxLen);
                }
            }
            return maxLen;
        }
    }
}
