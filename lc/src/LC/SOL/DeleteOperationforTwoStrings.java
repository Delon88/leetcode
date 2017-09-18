package LC.SOL;

public class DeleteOperationforTwoStrings {
    class Solution {
        public int minDistance(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();
            int[][] dp = new int[len1 + 1][len2 + 1];

            for (int i = 0; i <= len1; i++) {
                for (int j = 0; j <= len2; j++) {
                    if (i == 0 || j == 0) dp[i][j] = 0;
                    else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max( dp[i - 1][j] , dp[i][ j -1]);
                    }
                }
            }
            return len1 + len2 - 2 * dp[len1][len2];
        }
    }
}
