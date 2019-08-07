package LC.SOL;

public class MaximumSumCircularSubarray {
    class Solution {
        public int maxSubarraySumCircular(int[] A) {
            int minSum = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE, curMin = 0, curMax = 0, total = 0;
            for (int a : A) {
                curMax = Math.max(a, curMax + a);
                maxSum = Math.max(curMax, maxSum);
                curMin = Math.min(a, curMin + a);
                minSum = Math.min(minSum, curMin);
                total += a;
            }
            return maxSum > 0 ? Math.max( maxSum , total - minSum) : maxSum;
        }
    }
}
