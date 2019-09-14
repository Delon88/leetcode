package LC.SOL;

public class MaxConsecutiveOnesIII {
    class Solution {
        public int longestOnes(int[] A, int K) {
            int zero = 0, start = 0, end = 0;
            int ret = 0;
            for (; end < A.length; end++) {
                if (A[end] == 0) zero++;
                while (zero > K) {
                    if (A[start] == 0) zero--;
                    start++;
                }
                ret = Math.max(ret, end - start + 1);
            }
            return ret;
        }
    }
}
