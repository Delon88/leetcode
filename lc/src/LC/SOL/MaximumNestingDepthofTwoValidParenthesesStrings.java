package LC.SOL;

public class MaximumNestingDepthofTwoValidParenthesesStrings {
    class Solution {
        public int[] maxDepthAfterSplit(String seq) {
            int[] ret = new int[seq.length()];
            int d = 0;
            for ( int i = 0; i < seq.length(); i++) {
                char c =  seq.charAt(i);
                if ( c == '(') {
                    ret[i] = d % 2;
                    d++;
                } else {
                    d--;
                    ret[i] = d % 2;
                }
            }
            return ret;
        }
    }
}
