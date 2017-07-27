package LC.SOL;


public class PredicttheWinner {
    public class Solution {
        public boolean PredictTheWinner(int[] nums) {
            return canWin(nums, 0, nums.length - 1) >= 0;
        }

        int canWin(int[] nums, int start, int end) {
            return start == end ? nums[start] : Math.max(nums[start] - canWin(nums, start + 1, end), nums[end] - canWin(nums, start, end - 1));
        }
    }
}
