package LC.SOL;

public class SmallestRangeI {
    class Solution {
        public int smallestRangeI(int[] A, int K) {
            int min = A[0], max = A[0];
            for (int i : A) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
            int diff = max - min;
            int ret = diff > 2 * K ? diff - 2 * K : 0;
            return ret;
        }
    }
}
