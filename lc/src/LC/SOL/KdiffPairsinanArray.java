package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class KdiffPairsinanArray {
    public class Solution {
        public int findPairs(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k < 0) {
                return 0;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            int count = 0;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (k == 0) {
                    if (e.getValue() >= 2) {
                        count++;
                    }
                } else {
                    if (map.containsKey(e.getKey() + k)) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
