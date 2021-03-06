package LC.SOL;

public class SortColors {
    class Solution {
        public void sortColors(int[] nums) {
            int left = 0 , right = nums.length - 1;
            int i = 0 ;
            while ( i <= right ) {
                if ( nums[i] == 0 ) {
                    swap(nums, i , left);
                    left++;
                    i++;
                } else if ( nums[i] == 2) {
                    swap(nums, i , right);
                    right--;
                } else {
                    i++;
                }
            }
        }

        void swap(int[] nums, int i , int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
