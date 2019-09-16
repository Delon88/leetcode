package LC.SOL;

public class BestSightseeingPair {
    class Solution {
        public int maxScoreSightseeingPair(int[] A) {
            int max = 0;
            int maxP1 = 0;
            for (int i = 0; i < A.length; i++) {
                max = Math.max(max, maxP1 + A[i] - i);
                maxP1 = Math.max(maxP1, A[i] + i);
            }
            return max;
        }
    }
}
