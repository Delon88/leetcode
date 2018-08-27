package LC.SOL;

public class ConsecutiveNumbersSum {
    class Solution {
        public int consecutiveNumbersSum(int N) {
            int ret = 1;
            for (int k = 2; k <= (int) Math.sqrt(2 * N); k++) {
                if ((N - ((k - 1) * k / 2)) % k == 0 ) {
                    ret++;
                }
            }
            return ret;
        }
    }
}
