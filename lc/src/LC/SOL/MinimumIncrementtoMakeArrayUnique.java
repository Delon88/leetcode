package LC.SOL;

import java.util.Arrays;

public class MinimumIncrementtoMakeArrayUnique {
    class Solution {
        public int minIncrementForUnique(int[] A) {
            Arrays.sort(A);
            int need = 0, ret = 0;
            for (int a : A) {
                ret += Math.max(need - a, 0);
                need = Math.max(need, a) + 1;
            }
            return ret;
        }
    }
}
