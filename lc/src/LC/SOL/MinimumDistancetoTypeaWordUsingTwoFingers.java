package LC.SOL;

public class MinimumDistancetoTypeaWordUsingTwoFingers {
    class Solution {

        public int minimumDistance(String word) {
            int n = word.length();
            int[][][] dp = new int[27][27][n + 1];
            for (int pos = n - 1; pos >= 0; pos--) {
                int to = word.charAt(pos) - 'A';
                for (int i = 0; i < 27; i++) {
                    for (int j = 0; j < 27; j++) {
                        dp[i][j][pos] = Math.min(dp[i][to][pos + 1] + cost(j , to), dp[to][j][pos + 1] + cost(i , to));
                    }
                }
            }
            return dp[26][26][0];
        }

        int cost(int from, int to) {
            if (from == 26) return 0;
            return Math.abs(from / 6 - to / 6) + Math.abs(from % 6 - to % 6);
        }
    }
}
