package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class LengthofLongestFibonacciSubsequence {
    class Solution {
        public int lenLongestFibSubseq(int[] A) {
            int n = A.length;
            int[][] dp = new int[n][n];
            Map<Integer,Integer> map = new HashMap<>();
            int ret = 0;
            for ( int j = 0; j < A.length ; j++) {
                map.put(A[j] , j);
                for ( int i = 0 ; i < j ; i++) {
                    int k = map.getOrDefault(A[j] - A[i] , -1 );
                    dp[i][j] = ( k >= 0 && A[j] - A[i] < A[i] ? dp[k][i] + 1: 2);
                    ret = Math.max(ret, dp[i][j]);
                }
            }
            return ret > 2 ? ret : 0;
        }
    }
}
