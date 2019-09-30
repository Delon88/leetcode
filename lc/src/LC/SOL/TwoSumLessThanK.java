package LC.SOL;

import java.util.TreeSet;

public class TwoSumLessThanK {
    class Solution {
        public int twoSumLessThanK(int[] A, int K) {
            TreeSet<Integer> set = new TreeSet<>();
            int max = -1;
            for (int a : A) {
                Integer fl = set.lower(K - a);
                if ( fl != null ) {
                    max = Math.max(max, a + fl);
                }
                set.add(a);
            }
            return max;
        }
    }
}
