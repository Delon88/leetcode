package LC.SOL;

import java.util.Arrays;

public class MaximumLengthofPairChain {
    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (p1, p2) -> p1[1] - p2[1]);
            int end = pairs[0][1];
            int count = 1;
            for (int i = 1; i < pairs.length; i++) {
                if (pairs[i][0] > end) {
                    end = pairs[i][1];
                    count++;
                }
            }
            return count;
        }
    }
}
