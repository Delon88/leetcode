package LC.SOL;

import java.util.Arrays;

public class MaximumGap {
    class Solution {
        public int maximumGap(int[] nums) {
            if (nums == null || nums.length < 2) return 0;
            int min = nums[0], max = nums[0];
            for (int n : nums) {
                min = Math.min(n, min);
                max = Math.max(n, max);
            }
            int n = nums.length;
            int gap = (int) Math.ceil((double) (max - min) / (n - 1));
            int[] minBuckets = new int[n - 1];
            int[] maxBuckets = new int[n - 1];
            Arrays.fill(minBuckets, Integer.MAX_VALUE);
            Arrays.fill(maxBuckets, Integer.MIN_VALUE);
            for (int i : nums) {
                if (i == min || i == max) continue;
                int index = (i - min) / gap;
                minBuckets[index] = Math.min(minBuckets[index], i);
                maxBuckets[index] = Math.max(maxBuckets[index], i);
            }
            int maxGap = 0;
            int prev = min;

            // iterate buckets
            for ( int i = 0 ; i < n - 1; i++) {
                if ( minBuckets[i] == Integer.MAX_VALUE || maxBuckets[i] == Integer.MIN_VALUE) continue;
                maxGap = Math.max(minBuckets[i] - prev, maxGap);
                prev = maxBuckets[i];
            }
            maxGap = Math.max( max - prev, maxGap);
            return maxGap;
        }
    }
}
