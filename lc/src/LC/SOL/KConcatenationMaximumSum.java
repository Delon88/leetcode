package LC.SOL;

public class KConcatenationMaximumSum {
    class Solution {
        int mod = (int) Math.pow(10, 9) + 7;

        public int kConcatenationMaxSum(int[] arr, int k) {
            int n = arr.length;
            int kaden = kaden(arr);
            if (k == 1) return kaden;
            long sum = 0;
            for (int i : arr) sum += i;
            long prefix = 0, maxprefix = 0;
            long suffix = 0, maxSuffix = 0;
            for (int i = 0; i < n; i++) {
                prefix = (prefix + arr[i]);
                maxprefix = Math.max(maxprefix, prefix);
            }
            for (int i = n - 1; i >= 0; i--) {
                suffix = (suffix + arr[i]);
                maxSuffix = Math.max(suffix, maxSuffix);
            }
            if (sum >= 0) {
                return Math.max(kaden, (int) ((sum * (k - 2) + maxprefix + maxSuffix) % mod));
            } else {
                return Math.max(kaden, (int) ((maxprefix + maxSuffix) % mod));
            }
        }

        int kaden(int[] a) {
            long maxEnd = a[0], max = a[0];
            for (int i = 1; i < a.length; i++) {
                maxEnd = Math.max(a[i], maxEnd + a[i]);
                max = Math.max(max, maxEnd);
            }
            return (int) max;
        }
    }
}
