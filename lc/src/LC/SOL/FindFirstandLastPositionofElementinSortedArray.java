package LC.SOL;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if ( nums.length == 0 ) return new int[]{-1, -1};
        int left = binarySearch(nums, target);
        int right = binarySearch(nums, target + 1) - 1;
        if ( left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{left, right};
        }
    }

    int binarySearch(int[] nums, int target) {
        int low = 0 , high = nums.length- 1 , mid = 0;
        while ( low < high) {
            mid = low + ( high - low ) / 2;
            if ( nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if ( !(nums[low] >= target)) return low + 1;
        return low;
    }
}
