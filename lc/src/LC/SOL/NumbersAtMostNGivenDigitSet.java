package LC.SOL;

public class NumbersAtMostNGivenDigitSet {
    class Solution {
        public int atMostNGivenDigitSet(String[] D, int N) {
            String S = Integer.toString(N);
            int len = S.length();
            int[] dp = new int[len + 1];
            dp[len] = 1;
            for (int i = len - 1; i >= 0; i--) {
                
            }
        }
    }
}
