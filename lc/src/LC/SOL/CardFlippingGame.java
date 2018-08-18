package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class CardFlippingGame {
    class Solution {
        public int flipgame(int[] f, int[] b) {
            Set<Integer> same = new HashSet<>();
            for (int i = 0; i < f.length; ++i) if (f[i] == b[i]) same.add(f[i]);
            int res = Integer.MAX_VALUE;
            for (int i : f) if (!same.contains(i)) res = Math.min(res, i);
            for (int i : b) if (!same.contains(i)) res = Math.min(res, i);
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
}
