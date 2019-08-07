package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class _3SumWithMultiplicity {
    class Solution {
        public int threeSumMulti(int[] A, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int ret = 0;
            int mod = (int) Math.pow(10, 9) + 7;
            for (int i = 0; i < A.length; i++) {
                ret = (ret + map.getOrDefault(target - A[i], 0)) % mod;
                for (int j = 0; j < i; j++) {
                    int tmp = A[i] + A[j];
                    map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                }
            }
            return ret;
        }
    }
}
