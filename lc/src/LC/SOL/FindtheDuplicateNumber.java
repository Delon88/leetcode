package LC.SOL;

public class FindtheDuplicateNumber {
    class Solution {
        public int findDuplicate(int[] nums) {
            if (nums.length <= 1) return -1;
            int slow = 0, fast = 0;
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (fast != slow);
            fast = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
}
