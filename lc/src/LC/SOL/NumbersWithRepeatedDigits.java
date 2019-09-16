package LC.SOL;

import java.util.*;

public class NumbersWithRepeatedDigits {
    class Solution {
        public int numDupDigitsAtMostN(int N) {
            List<Integer> L = new ArrayList<>();
            for (int x = N + 1; x > 0; x /= 10) {
                L.add(x % 10);
            }
            Collections.reverse(L);
            // count number wiht digits < N
            int ret = 0, n = L.size();
            for (int i = 1; i < n; i++) {
                ret += 9 * permu(9, i - 1);
            }
            // 8766
            //1XXX ~ 7XXX
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = i == 0 ? 1 : 0; j < L.get(i); j++) {
                    if ( !seen.contains(j)) ret += permu( 9 - i, n - i - 1);
                }
                if ( seen.contains(L.get(i))) break;
                seen.add(L.get(i));
            }
            return N - ret;
        }

        int permu(int m, int n) {
            int ret = 1;
            for (int i = 0; i < n; i++) {
                ret *= m;
                m--;
            }
            return ret;
        }
    }
}
