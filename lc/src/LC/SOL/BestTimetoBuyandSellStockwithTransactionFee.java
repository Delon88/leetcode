package LC.SOL;

public class BestTimetoBuyandSellStockwithTransactionFee {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int nothold = 0;
            int hold = Integer.MIN_VALUE;
            for ( int p : prices) {
                int temp = nothold;
                nothold = Math.max( nothold , hold + p);
                hold = Math.max(hold, nothold - p - fee);
            }
            return nothold;
        }
    }
}
