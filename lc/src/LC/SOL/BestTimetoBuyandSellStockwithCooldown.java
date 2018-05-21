package LC.SOL;

public class BestTimetoBuyandSellStockwithCooldown {
    class Solution {
        public int maxProfit(int[] prices) {
            if ( prices.length < 2) return 0;
            int s0 = 0, s1 = -prices[0] , s2 = 0;
            for ( int i = 1 ; i < prices.length ; i++) {
                int tmp = s1;
                s1 = Math.max(s1 , s0 - prices[i]);
                s0 = Math.max(s0, s2);
                s2 = s1 + prices[i];
            }
            return Math.max(s0, s2);
        }
    }
}
