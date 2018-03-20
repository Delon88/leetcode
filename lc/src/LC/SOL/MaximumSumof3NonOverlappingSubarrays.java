package LC.SOL;

public class MaximumSumof3NonOverlappingSubarrays {
    class Solution {
        // dp
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int n = nums.length;
            int[] left = new int[n - k + 1];
            int[] right = new int[n  - k + 1];
            int tmp = 0;
            for ( int i = 0 ; i < n ; i++ ) {
                tmp += nums[i];
                if ( i < k  ) {
                    continue;
                } else {

                    tmp -= nums[i - k];
                }
            }
        }
    }
}
