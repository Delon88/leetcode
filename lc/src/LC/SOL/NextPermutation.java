package LC.SOL;


public class NextPermutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length <= 1) return;
            int n = nums.length;
            for (int i = nums.length - 2; i >= 0; i--) {
                // find the first one that A[i] > A[i - 1]
                if (nums[i] < nums[i + 1]) {
                    reverse(nums, i + 1, n - 1);
                    for (int j = i + 1; j < nums.length; j++) {
                        if ( nums[j] > nums[i]) {
                            swap(nums, i , j );
                            return;
                        }
                    }
                }
            }
            reverse(nums, 0, n - 1);
        }

        void reverse(int[] nums, int start, int end) {
            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
