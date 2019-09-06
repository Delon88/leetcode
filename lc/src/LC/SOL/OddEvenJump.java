package LC.SOL;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {
    class Solution {
        public int oddEvenJumps(int[] A) {
            int n = A.length;
            boolean[] higher = new boolean[n], lower = new boolean[n];
            higher[n - 1] = true;
            lower[n - 1] = true;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(A[n - 1], n - 1);
            int ret = 1;
            for (int i = n - 2; i >= 0; i--) {
                Map.Entry<Integer, Integer> hi = map.ceilingEntry(A[i]), low = map.floorEntry(A[i]);
                if (hi != null) higher[i] = lower[hi.getValue()];
                if (low != null) lower[i] = higher[low.getValue()];
                if (higher[i]) ret++;
                map.put(A[i], i);
            }
            return ret;
        }
    }
}
