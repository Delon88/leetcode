package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class NumberofSubmatricesThatSumtoTarget {
    class Solution {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int[][] A = matrix.clone();
            int m = A.length, n = A[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    A[i][j] += A[i][j - 1];
                }
            }
            int ret = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    map.put(0, 1);
                    int cur = 0;
                    for (int k = 0; k < m; k++) {
                        cur += A[k][j] - (i == 0 ? 0 : A[k][i - 1]);
                        ret += map.getOrDefault(cur - target, 0);
                        map.put(cur, map.getOrDefault(cur, 0) + 1);
                    }
                }
            }
            return ret;
        }
    }
}
