package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsofLargeGroups {
    class Solution {
        public List<List<Integer>> largeGroupPositions(String S) {
            int i = 0;
            List<List<Integer>> ret = new ArrayList<>();
            while (i < S.length()) {
                char c = S.charAt(i);
                int j = i;
                while ( i < S.length() && S.charAt(i) == c ) {
                    i++;
                }
                if ( i - j >= 3 ) ret.add(Arrays.asList(j , i - 1));
            }
            return ret;
        }
    }
}
