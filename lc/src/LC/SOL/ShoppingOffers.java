package LC.SOL;

import java.util.Arrays;
import java.util.List;

public class ShoppingOffers {
    class Solution {

        int min = Integer.MAX_VALUE;

        List<Integer> price = null;

        List<List<Integer>> special = null;

        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            this.price = price;
            this.special = special;
            int[] have = new int[needs.size()];
            int[] ne = new int[needs.size()];
            for (int i = 0; i < needs.size(); i++) {
                ne[i] = needs.get(i);
            }
            dfs(0, have, ne);
            return min;
        }

        void dfs(int spent, int[] have, int[] needs) {
            for (int i = 0; i < have.length; i++) {
                if (have[i] > needs[i]) {
                    return;
                }
            }
            if (Arrays.equals(have, needs)) {
                min = Math.min(min, spent);
            }
            // do not use deal, calculate the rest
            int rest = costForNonDeal(have, needs);
            min = Math.min(spent + rest, min);

            // use the deal,
            for (int i = 0; i < special.size(); i++) {
                List<Integer> deal = special.get(i);
                for (int j = 0; j < deal.size() - 1; j++) {
                    have[j] += deal.get(j);
                }
                dfs(spent + deal.get(deal.size() - 1), have, needs);
                for (int j = 0; j < deal.size() - 1; j++) {
                    have[j] -= deal.get(j);
                }
            }


        }

        int costForNonDeal(int[] have, int[] need) {
            int sum = 0;
            for (int i = 0; i < have.length; i++) {
                sum += (need[i] - have[i]) * price.get(i);
            }
            return sum;
        }
    }
}
