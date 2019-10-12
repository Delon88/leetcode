package LC.SOL;

public class MaximumSubarraySumwithOneDeletion {
    class Solution {
        public int maximumSum(int[] arr) {
            int n = arr.length;
            int[] maxEnd = new int[n], maxStart = new int[n];
            int max = arr[0];
            maxEnd[0] = arr[0];
            for (int i = 1; i < n; i++) {
                maxEnd[i] = Math.max(arr[i], maxEnd[i - 1] + arr[i]);
                max = Math.max(maxEnd[i], max);
            }
            maxStart[n - 1] = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                maxStart[i] = Math.max(arr[i], maxStart[i + 1] + arr[i]);
            }
            for (int i = 1; i < n - 1; i++) {
                max = Math.max(maxEnd[i - 1] + maxStart[i + 1], max);
            }
            return max;
        }
    }
}
