package LC.SOL;

public class BestTimetoBuyandSellStockIII {
    class Solution {
        public int maxProfit(int[] prices) {
            if ( prices.length < 2 ) return 0;
            return solve(prices, 2);
        }

        int solve(int[] prices, int k ){
            int n = prices.length;
            int[] localMax = new int[k + 1];
            int[] globalMax = new int[k + 1];
            for ( int i = 1 ; i < n ; i++) {
                int diff = prices[i] - prices[i  - 1];
                for ( int j = k ; j >= 1 ; j--) {
                    localMax[j] = Math.max(globalMax[j - 1] + Math.max(diff, 0), localMax[j] + diff);
                    globalMax[j] = Math.max(globalMax[j], localMax[j]);
                }
            }
            return globalMax[k];
        }
    }
}
