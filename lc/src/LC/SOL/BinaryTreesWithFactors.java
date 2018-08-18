package LC.SOL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreesWithFactors {
    class Solution {
        public int numFactoredBinaryTrees(int[] A) {
            long ret = 0l, mod = (long) Math.pow(10, 9) + 7;
            Arrays.sort(A);
            Map<Integer, Long> dp = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                dp.put(A[i], 1l);
                for (int j = 0; j < i; j++) {
                    if (A[i] % A[j] == 0 && dp.containsKey(A[i] / A[j])) {
                        dp.put(A[i], (dp.get(A[i]) + dp.get(A[j]) * dp.get(A[i] / A[j])) % mod);
                    }
                }
            }
            for (long v : dp.values()) ret = (ret + v) % mod;
            return (int) ret;
        }
    }
}
