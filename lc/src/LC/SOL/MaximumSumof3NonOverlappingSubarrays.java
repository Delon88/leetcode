package LC.SOL;

public class MaximumSumof3NonOverlappingSubarrays {
    class Solution {
        // dp
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int n = nums.length;
            if (n < 3 * k) return new int[0];
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + nums[i];
            int[] left = new int[n];
            for (int i = k, tmp = sum[k] - sum[0]; i < n; i++) {
                if (sum[i + 1] - sum[i + 1 - k] > tmp) {
                    left[i] = i + 1 - k;
                    tmp = sum[i + 1] - sum[i - k + 1];
                } else {
                    left[i] = left[i - 1];
                }
            }
            int[] right = new int[n];
            right[n - k] = n - k;
            for (int i = n - k - 1, tmp = sum[n] - sum[n - k]; i >= 0; i--) {
                if (sum[i + k] - sum[i] >= tmp) {
                    right[i] = i;
                    tmp = sum[i + k] - sum[i];
                } else {
                    right[i] = right[i + 1];
                }
            }

            int max = Integer.MIN_VALUE;
            int[] ret = {-1, -1, -1};
            for (int i = k; i <= n - 2 * k; i++) {
                int l = left[i - 1], r = right[i + k];
                int tmp = sum[l + k] - sum[l] + sum[i + k] - sum[i] + sum[r + k] - sum[r];
                if (tmp > max) {
                    max = tmp;
                    ret[0] = l ; ret[1] = i; ret[2] = r;
                }
            }
            return ret;
        }
    }
}
