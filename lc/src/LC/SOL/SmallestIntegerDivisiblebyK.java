package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class SmallestIntegerDivisiblebyK {
    class Solution {
        public int smallestRepunitDivByK(int K) {
            if (K % 2 == 0) return -1;
            Set<Integer> re = new HashSet<>();
            int mod = 0;
            for (int i = 1; i <= K; i++) {
                mod = (10 * mod + 1 ) % K;
                if ( mod == 0 ) return i;
                if ( re.contains(mod)) return -1;
                re.add(mod);
            }
            return -1;
        }
    }
}
