package LC.SOL;

import java.util.Arrays;

public class FindKthSmallestPairDistance {
    static class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            if (nums.length < 2) return -1;
            Arrays.sort(nums);
            int lo = nums[1] - nums[0];
            int n = nums.length;
            for (int i = 1; i < n - 1; i++) {
                lo = Math.min(lo, nums[i + 1] - nums[i]);
            }
            int hi = nums[n - 1] - nums[0];
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (predicate(nums, mid, k)) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            return lo;
        }

        boolean predicate(int[] nums, int diff, int k) {
            int n = nums.length;
            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                int lo = i, hi = n - 1;
                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (nums[mid] - nums[i] > diff) {
                        hi = mid;
                    } else {
                        lo = mid + 1;
                    }
                }
                if ( !(nums[lo] - nums[i] > diff)) lo = hi + 1;
                count += lo - i - 1;
            }
            return count >= k;
        }
    }

    public static void main(String[] args) {
        // [1, 4, 5, 6, 7, 8, 9, 9, 10, 10]
        int[] num = {9, 10, 7, 10, 6, 1, 5, 4, 9, 8};
        System.out.println(new Solution().smallestDistancePair(num, 18));
    }
}
