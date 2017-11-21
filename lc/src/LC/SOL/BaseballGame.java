package LC.SOL;

public class BaseballGame {
    class Solution {
        public int calPoints(String[] ops) {
            int[] scores = new int[ops.length];
            for ( int i = 0 ; i < ops.length ; i++) {
                if ( "+".equals(ops[i]) ) {
                    scores[i] = scores[i - 1] + scores[i - 2];
                } else if (  "D".equals(ops[i])) {
                    scores[i] = 2 * scores[i - 1];
                } else if ( "C".equals(ops[i])) {
                    scores[i] = scores[i - 1]
                } else {

                }
            }
        }
    }
}
