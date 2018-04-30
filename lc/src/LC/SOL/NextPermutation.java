package LC.SOL;

import java.util.Arrays;

public class NextPermutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            if ( nums.length <= 1) return;
            for (int i = nums.length - 1; i > 0; i--) {
                // find the first one that A[i] > A[i - 1]
                if (nums[i] > nums[i - 1]) {
                    reverse(nums, i, nums.length - 1);
                    for (int j = i; j < nums.length; j++) {
                        if (nums[j] > nums[i - 1]) {
                            swap(nums, i - 1, j);
                            return;
                        }
                    }
                }
            }
            reverse(nums, 0 ,nums.length - 1);
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
