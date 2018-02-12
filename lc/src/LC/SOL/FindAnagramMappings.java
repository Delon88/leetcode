package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramMappings {
    class Solution {
        public int[] anagramMappings(int[] A, int[] B) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < B.length; i++) {
                map.put(B[i], i);
            }

            int[] ret = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                ret[i] = map.get(A[i]);
            }
            return ret;
        }
    }
}
