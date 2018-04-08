package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class _4SumII {
    class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < D.length; j++) {
                    map.put(C[i] + D[j], map.getOrDefault(C[i] + D[j], 0) + 1);
                }
            }

            int count = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    if ( map.containsKey(-(A[i] + B[j])) ) count+= map.get((-(A[i] + B[j])));
                }
            }
            return count;
        }
    }
}
