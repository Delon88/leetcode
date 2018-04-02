package LC.SOL;

public class SplitArrayLargestSum {

    public class Solution {
        public int splitArray(int[] nums, int m) {
            int start = nums[0], end = 0;
            for (int n : nums) {
                start = Math.max(start, n);
                end += n;
            }

            int mid = 0;
            while (start < end) {
                mid = start + (end - start) / 2;
                if ( countSub(nums, m , mid)) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return start;
        }

        boolean countSub(int[] nums, int m, int target) {
            int sum = 0, count = 1;
            for (int i = 0; i < nums.length; i++ ) {
                if (sum + nums[i] <= target) {
                    sum += nums[i];
                } else {
                    sum = nums[i];
                    count++;
                }
            }
            return count <= m;
        }
    }

}
