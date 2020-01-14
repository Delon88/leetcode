package LC.SOL;

public class GreatestSumDivisiblebyThree {
    class Solution {
        public int maxSumDivThree(int[] nums) {
            int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
            for (int a : nums) {
                int[] next = new int[3];
                for (int i = 0; i < 3; i++) {
                    next[ (a + i) % 3] = Math.max(dp[ (a + i) % 3], dp[i] + a);
                }
                dp = next;
            }
            return dp[0];
        }
    }
}
