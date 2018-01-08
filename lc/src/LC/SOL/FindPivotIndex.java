package LC.SOL;

public class FindPivotIndex {
    class Solution {
        public int pivotIndex(int[] nums) {
            int n = nums.length;
            int[] rightSum = new int[n + 1];
            int sum = 0;
            for (int i = n - 1; i >= 0 ; i--) {
                sum += nums[i];
                rightSum[i] = sum;
            }
            sum = 0;
            for ( int i = 0 ; i < n -1 ; i++) {
                if ( sum == rightSum[ i + 1 ]) return i;
                sum += nums[i];
            }
            return -1;
        }
    }
}
