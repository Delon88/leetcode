package LC.SOL;

public class BestTimetoBuyandSellStockwithCooldown {
    class Solution {
        public int maxProfit(int[] prices) {
            int sell = 0, sold = 0, buy = Integer.MIN_VALUE, prev_buy;
            for (int price : prices) {
                prev_buy = buy;
                buy = Math.max(sold - price, prev_buy);
                sold = sell;
                sell = Math.max(prev_buy + price, sold);
            }
            return sell;
        }
    }
}
