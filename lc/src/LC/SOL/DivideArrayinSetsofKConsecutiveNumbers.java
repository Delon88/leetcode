package LC.SOL;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DivideArrayinSetsofKConsecutiveNumbers {
    class Solution {
        public boolean isPossibleDivide(int[] nums, int k) {
            if (k == 0 || nums.length == 0 || nums.length % k != 0) return false;
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }

            for (int n : nums) {
                int start = n;
                while (map.getOrDefault(start - 1, 0) > 0) start--;
                for (; start <= n; start++) {
                    int times = map.get(start);
                    if (times > 0) {
                        for ( int i = start; i < start + k ; i++) {
                            if ( map.getOrDefault(i, 0) < times) return false;
                            map.put(i, map.get(i) - times);
                        }
                    }
                }
            }
            return true;
        }
    }
}
