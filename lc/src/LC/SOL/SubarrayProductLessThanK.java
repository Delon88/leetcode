package LC.SOL;

public class SubarrayProductLessThanK {
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            long mul = 1l;
            int start = 0;
            int end = 0 ;
            int count = 0;
            while ( end < nums.length) {
                mul *= nums[end];
                while ( start <= end && mul >= k ) {
                    mul /= nums[start];
                    start++;
                }
                count +=  end - start + 1;
                end++;
            }
            return count;
        }
    }
}
