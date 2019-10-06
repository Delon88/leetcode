package LC.SOL;

public class FillingBookcaseShelves {
    class Solution {
        public int minHeightShelves(int[][] books, int shelf_width) {
            // dp[i] minHeight for (1...i) books.
            // dp[i + 1] = dp[i] + height[i + 1],   dp[j] + max(h[j+ 1],.....h[i])
            int[] dp = new int[books.length + 1];
            dp[0] = 0;
            for (int i = 1; i <= books.length; i++) {
                int w = books[i - 1][0], h = books[i - 1][1];
                dp[i] = dp[i - 1] + h;
                for (int j = i - 1; j > 0 && w + books[j - 1][0] <= shelf_width; j--) {
                    h = Math.max(books[j - 1][1], h);
                    w += books[j - 1][0];
                    dp[i] = Math.min(dp[i], dp[j - 1] + h);
                }
            }
            return dp[books.length];
        }
    }
}
