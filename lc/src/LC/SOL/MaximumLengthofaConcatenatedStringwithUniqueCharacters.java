package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    class Solution {
        public int maxLength(List<String> arr) {
            List<Integer> dp = new ArrayList<>();
            dp.add(0);
            int max = 0;
            for (String s : arr) {
                int bv = 0, dup = 0;
                for (char c : s.toCharArray()) {
                    dup |= bv & (1 << (c - 'a'));
                    bv |= (1 << (c - 'a'));
                }
                if (dup > 0) continue;
                for (int i = dp.size() - 1; i >= 0; i--) {
                    if ( (dp.get(i) & bv) > 0 ) continue;
                    dp.add(dp.get(i) | bv);
                    max = Math.max(max, Integer.bitCount(dp.get(i) | bv));
                }
            }
            return max;
        }
    }
}
