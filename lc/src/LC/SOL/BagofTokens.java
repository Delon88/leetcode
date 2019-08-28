package LC.SOL;

import java.util.Arrays;

public class BagofTokens {
    class Solution {
        public int bagOfTokensScore(int[] tokens, int P) {
            Arrays.sort(tokens);
            int ret = 0, points = 0, i = 0, j = tokens.length - 1;
            while (i <= j) {
                if (P >= tokens[i]) {
                    P -= tokens[i++];
                    points++;
                    ret = Math.max(ret, points);
                } else if (points > 0) {
                    P += tokens[j--];
                    points--;
                } else {
                    break;
                }
            }
            return ret;
        }
    }
}
