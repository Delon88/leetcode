package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageOverlap {
    class Solution {
        public int largestOverlap(int[][] A, int[][] B) {
            int N = A.length;
            List<Integer> LA = new ArrayList<>();
            List<Integer> LB = new ArrayList<>();
            for (int i = 0; i < N * N; i++) {
                if (A[i / N][i % N] == 1) LA.add(i / N * 100 + i % N);
                if (B[i / N][i % N] == 1) LB.add(i / N * 100 + i % N);
            }
            Map<Integer,Integer> map = new HashMap<>();
            for ( int i : LA ) {
                for ( int j : LB) {
                    map.put(i - j , map.getOrDefault(i - j , 0) + 1);
                }
            }
            int max = 0;
            for ( int v : map.values())  max = Math.max(max , v);
            return max;
        }
    }
}
