package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring {
    class Solution {
        public int longestRepeatingSubstring(String S) {
            Set<String> set = new HashSet<>();
            int n = S.length();
            for (int len = n - 1; len > 0; len--) {
                set.clear();
                for (int i = 0; i + len <= n; i++) {
                    String k = S.substring(i , i + len);
                    if ( !set.add(k)) return len;
                }
            }
            return 0;
        }
    }

    class Solution1 {
        public int longestRepeatingSubstring(String S) {
            int n = S.length();
            int[][] dp = new int[n + 1][n + 1];
            int ret = 0;
            for ( int i = 1; i <= n ; i++) {

            }
        }
    }
}
