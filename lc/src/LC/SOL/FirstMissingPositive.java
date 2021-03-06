package LC.SOL;

public class FirstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                while ( nums[i] > 0 && nums[i] <= n && nums[nums[i] -1] != nums[i]) {
                    // swap number and mark negative
                    int temp = nums[nums[i] - 1];
                    nums[nums[i]  -1] = nums[i];
                    nums[i] = temp;
                }
            }

            for ( int i = 0 ; i < nums.length ; i++) {
                if ( nums[i] != i + 1) return i + 1;
            }
            return n + 1;
        }
    }
}
