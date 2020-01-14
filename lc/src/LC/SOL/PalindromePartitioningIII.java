package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class PalindromePartitioningIII {
    class Solution {
        Map<String, Integer> map = new HashMap<>();

        public int palindromePartition(String s, int k) {
            if ( s.length() == k ) return 0;
            int n = s.length();
            int[][] dp = new int[k][n + 1];
            for (int i = 1; i <= n; i++) {
                dp[0][i] = minReplace(s.substring(0, i));
            }
            for ( int i = 1 ; i < k ; i++) {
                for ( int j = i ; j <= n ; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for ( int p = j  ; p >= i  ; p--) {
                        dp[i][j] = Math.min( dp[i][j], dp[i-1][p - 1] + minReplace(s.substring(p - 1, j)));
                    }
                }
            }
            return dp[k - 1][n];
        }

        private int minReplace(String str) {
            if (str == null || str.length() == 0) return 0;
            if (map.containsKey(str)) return map.get(str);
            int res = 0;
            for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
                if (str.charAt(i) != str.charAt(j)) res++;
            }
            map.put(str, res);
            return res;
        }
    }
}
