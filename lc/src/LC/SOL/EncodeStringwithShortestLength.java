package LC.SOL;

public class EncodeStringwithShortestLength {
    class Solution {
        public String encode(String s) {
            int n = s.length();
            String[][] dp = new String[n][n];
            for (int len = 1; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    int j = i + len - 1;
                    String subStr = s.substring(i, j + 1);
                    if (len <= 4) {
                        dp[i][j] = subStr;
                    } else {
                        dp[i][j] = subStr;
                        for (int k = i; k < j; k++) {
                            if ((dp[i][k] + dp[k + 1][j]).length() < dp[i][j].length()) {
                                dp[i][j] = dp[i][k] + dp[k + 1][j];
                            }
                        }
                        // check if dp[i][j] can be further encoded
                        for (int k = 0; k < subStr.length(); k++) {
                            String repeat = subStr.substring(0, k + 1);
                            if (subStr.length() % repeat.length() == 0 &&
                                    subStr.replaceAll(repeat, "").length() == 0) {
                                String encoded = (subStr.length() / repeat.length()) + "[" + dp[i][i + k] + "]";
                                if (encoded.length() < dp[i][j].length()) {
                                    dp[i][j] = encoded;
                                }
                            }
                        }
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}
