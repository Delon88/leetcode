package LC.SOL;

public class RegularExpressionMatching {
    class Solution {
        public boolean isMatch(String s, String p) {
            if ( p.isEmpty()) return s.isEmpty();
            boolean firstMatch = (  !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
            if ( p.length() >= 2 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2)) || ( firstMatch && isMatch(s.substring(1), p));
            } else {
                return firstMatch && isMatch(s.substring(1) , p.substring(1));
            }
        }
    }

    class SolutionDP {
        public boolean isMatch(String s, String p) {

            if (s == null || p == null) {
                return false;
            }
            boolean[][] dp = new boolean[s.length()+1][p.length()+1];
            dp[0][0] = true;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '*' && dp[0][i-1]) {
                    dp[0][i+1] = true;
                }
            }
            for (int i = 0 ; i < s.length(); i++) {
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) == '.') {
                        dp[i+1][j+1] = dp[i][j];
                    }
                    if (p.charAt(j) == s.charAt(i)) {
                        dp[i+1][j+1] = dp[i][j];
                    }
                    if (p.charAt(j) == '*') {
                        if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                            dp[i+1][j+1] = dp[i+1][j-1];
                        } else {
                            dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
