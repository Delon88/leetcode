package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingOffers {
    class Solution {

        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            return dfs(price, special, needs, 0);
        }

        int dfs(List<Integer> price, List<List<Integer>> spec, List<Integer> need, int pos) {
            int ret = directBuy(price, need);
            for ( int i = pos ; i < spec.size() ; i++) {
                List<Integer> offer = spec.get(i);
                List<Integer> nextNeed = new ArrayList<>();
                for ( int j = 0 ; j < need.size() ; j++) {
                    if ( need.get(j) <  offer.get(j) ) {
                        nextNeed = null;
                        break;
                    }
                    nextNeed.add(need.get(j) - offer.get(j));
                }
                if ( nextNeed != null ) {
                    ret = Math.min(ret, offer.get(offer.size() - 1) + dfs(price, spec, nextNeed, i) );
                }
            }
            return ret;
        }

        int directBuy(List<Integer> price, List<Integer> need) {
            int sum = 0;
            for ( int i = 0  ; i < price.size() ; i++) {
                sum += price.get(i) * need.get(i);
            }
            return sum;
        }
    }
}
