package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesIISubsequence {
    public class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            int ret = 0;
            Map<Integer, Integer>[] map = new HashMap[A.length];
            for (int i = 0; i < A.length; i++) {
                map[i] = new HashMap<>();
                for (int j = 0; j < i; j++) {
                    long diff = (long)A[i] - A[j];
                    if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                        continue;
                    }
                    int d = (int) diff;
                    int t_jd = map[j].getOrDefault(d, 0);
                    int t_id = map[i].getOrDefault(d, 0);
                    ret += t_jd;
                    map[i].put(d, t_id + t_jd + 1);
                }
            }
            return ret;
        }
    }
}
