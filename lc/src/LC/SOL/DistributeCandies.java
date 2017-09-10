package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    class Solution {
        public int distributeCandies(int[] candies) {
            Set<Integer> set = new HashSet();
            for ( int n : candies) {
                set.add(n);
            }
            if ( set.size() > candies.length / 2 ) return candies.length / 2;
            return set.size();
         }
    }
}
