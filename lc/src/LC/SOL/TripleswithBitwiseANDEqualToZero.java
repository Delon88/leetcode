package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class TripleswithBitwiseANDEqualToZero {
    class Solution {
        public int countTriplets(int[] A) {
            int n = 1 << 16, m = 3;
            int[][] dp = new int[m + 1][n];
            dp[0][n - 1] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int a : A) {
                        dp[i + 1][a & j] += dp[i][j];
                    }
                }
            }
            return dp[m][0];
        }
    }


    class Solution1 {
        public int countTriplets(int[] A) {
            int ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    int num = A[i] & A[j];
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
            for (int i = 0; i < A.length; i++) {
                for (int num : map.keySet()) {
                    if ((A[i] & num) == 0) {
                        ans += map.get(num);
                    }
                }
            }
            return ans;
        }
    }

}
