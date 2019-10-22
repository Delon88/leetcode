package LC.SOL;

public class BestTimetoBuyandSellStockIII {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) return 0;
            return solve(prices, 2);
        }

        int solve(int[] prices, int totalK) {
            if(prices == null || prices.length == 0) return 0;
            int[][] dp = new int[totalK+1][prices.length];
            for(int k = 1;k<=totalK;k++){//profit = 0 when k = 0
                int maxDiff = -prices[0];//dp[0][-1] - price[0]
                for(int i = 1;i< prices.length;i++){
                    //if(i = 1) maxDiff = 0 - prices[0];
                    if(i>1) maxDiff = Math.max(maxDiff,dp[k-1][i-2]-prices[i-1]);//maxDiff = dp[k-1][i-2] -  prices[i-1]
                    dp[k][i] = Math.max(dp[k][i-1],maxDiff + prices[i]);//sell on day i OR not
                }
            }
            return dp[totalK][prices.length-1];
        }
    }
}
