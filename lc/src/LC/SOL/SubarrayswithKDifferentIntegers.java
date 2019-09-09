package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class SubarrayswithKDifferentIntegers {
    class Solution {
        public int subarraysWithKDistinct(int[] A, int K) {
            return atMostK(A, K) - atMostK(A, K - 1);
        }

        int atMostK(int[] A, int K) {
            Map<Integer, Integer> map = new HashMap<>();
            int start = 0, end = 0;
            int ret = 0;
            for (; end < A.length; end++) {
                map.put(A[end], map.getOrDefault(A[end], 0) + 1);
                while (map.size() > K) {
                    map.put(A[start], map.get(A[start]) - 1);
                    if (map.get(A[start]) <= 0) map.remove(A[start]);
                    start++;
                }
                ret += end - start + 1;
            }
            return ret;
        }
    }
}
