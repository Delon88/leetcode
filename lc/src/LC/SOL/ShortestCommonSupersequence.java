package LC.SOL;

import java.util.Arrays;

public class ShortestCommonSupersequence {
    class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {
            String lcs = LCS(str1, str2);
            StringBuilder b = new StringBuilder();
            int i = 0 , j = 0;
            for ( char  c: lcs.toCharArray()) {
                while ( i < str1.length() && str1.charAt(i) != c ) {b.append(str1.charAt(i++));}
                while ( j < str2.length() && str2.charAt(j) != c ) {b.append(str2.charAt(j++));}
                b.append(c);i++;j++;
            }
            return b.append(str1.substring(i)).append(str2.substring(j)).toString();
        }

        private String LCS(String s1, String s2) {
            int l1 = s1.length(), l2 = s2.length();
            String[][] dp = new String[l1 + 1][l2 + 1];
            for ( String[] d: dp) Arrays.fill(d , "");
            for ( int i = 1 ; i <= l1 ; i++) {
                for ( int j = 1 ; j <= l2; j++) {
                    if ( s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j  - 1] + s1.charAt(i - 1);
                    } else {
                        dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i- 1][j] : dp[i][j - 1];
                    }
                }
            }
            return dp[l1][l2];
        }
    }
}
