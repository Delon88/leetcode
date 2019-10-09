package LC.SOL;

public class CheckIfaNumberIsMajorityElementinaSortedArray {
    class Solution {
        public boolean isMajorityElement(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if ( nums[l] == target && l + nums.length / 2 < nums.length && nums[l + nums.length / 2] == target) return true;
            return false;
        }
    }
}
