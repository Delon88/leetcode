package LC.SOL;

public class LastStoneWeightII {
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            boolean[] dp = new boolean[3000];
            dp[0] = true;
            int sum = 0;
            for (int s : stones) {
                sum += s;
                for (int i = sum; i >= s; i--) {
                    dp[i] |= dp[i - s];
                }
            }
            for (int i = sum / 2; i > 0; i--) {
                if ( dp[i] ) return sum - 2 * i;
            }
            return 0;
        }
    }
}
