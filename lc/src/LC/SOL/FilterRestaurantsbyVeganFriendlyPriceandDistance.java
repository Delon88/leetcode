package LC.SOL;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterRestaurantsbyVeganFriendlyPriceandDistance {
    class Solution {
        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            return Arrays.stream(restaurants)
                    .filter(r -> r[2] >= veganFriendly && r[3] <= maxPrice && r[4] <= maxDistance).sorted((a, b) -> {
                        if (a[1] == b[1])
                            return b[0] - a[0];
                        else
                            return b[1] - a[1];
                    }).map(r -> r[0]).collect(Collectors.toList());
        }
    }
}
