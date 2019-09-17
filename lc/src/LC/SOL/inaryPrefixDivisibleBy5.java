package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class inaryPrefixDivisibleBy5 {
    class Solution {
        public List<Boolean> prefixesDivBy5(int[] A) {
            int num = 0;
            List<Boolean> ret = new ArrayList<>();
            for (int a : A) {
                num = (num * 2 + a) % 5;
                ret.add((num % 5 == 0));
            }
            return ret;
        }
    }
}
