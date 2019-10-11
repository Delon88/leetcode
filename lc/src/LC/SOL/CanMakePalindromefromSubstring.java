package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class CanMakePalindromefromSubstring {
    class Solution {
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            List<Boolean> ret = new ArrayList<>();
            int n = s.length();
            int[][] dp = new int[n + 1][26];
            for (int i = 0; i < n; i++) {
                dp[i + 1] = dp[i].clone();
                dp[i + 1][s.charAt(i) - 'a']++;
            }
            for (int[] q : queries) {
                int sum = 0;
                for( int i = 0 ; i < 26 ; i++) {
                    sum += ( dp[q[1] + 1][i] - dp[q[0]][i]) % 2;
                }
                ret.add(sum / 2 <= q[2]);
            }
            return ret;
        }
    }
}
