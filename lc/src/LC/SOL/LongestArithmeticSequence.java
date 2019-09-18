package LC.SOL;

import java.util.HashMap;

public class LongestArithmeticSequence {
    class Solution {
        // dp[d][index]
        public int longestArithSeqLength(int[] A) {
            int ret = 2, n = A.length;
            HashMap<Integer, Integer>[] dp = new HashMap[n];
            for (int j = 0; j < A.length; j++) {
                dp[j] = new HashMap<>();
                for (int i = 0; i < j; i++) {
                    int d = A[j] - A[i];
                    dp[j].put(d , dp[i].getOrDefault(d , 1 ) + 1);
                    ret = Math.max(ret, dp[j].get(d));
                }
            }
            return ret;
        }
    }
}
