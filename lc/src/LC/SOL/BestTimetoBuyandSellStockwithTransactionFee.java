package LC.SOL;

public class BestTimetoBuyandSellStockwithTransactionFee {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int s0 = 0, s1 = Integer.MIN_VALUE;
            for ( int p : prices ) {
                int tmp = s0;
                s0 = Math.max(s1 + p, s0);
                s1 = Math.max(s1, tmp - p - fee);
            }
            return s0;
        }
    }
}
