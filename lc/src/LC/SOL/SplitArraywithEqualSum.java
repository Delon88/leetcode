package LC.SOL;

public class SplitArraywithEqualSum {
    class Solution {
        public boolean splitArray(int[] nums) {
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }
            if (sum % 4 != 0) return false;
        }
    }
}
