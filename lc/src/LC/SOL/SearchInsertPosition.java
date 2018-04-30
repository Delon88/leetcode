package LC.SOL;

public class SearchInsertPosition {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int low = 0 , high = nums.length - 1, mid = 0;
            while ( low < high ) {
                mid = low + ( high - low ) / 2;
                if ( nums[mid] >= target ) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            if ( !(nums[low] >= target) ) return low + 1;
            else return low;
        }
    }
}
