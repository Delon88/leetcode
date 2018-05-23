package LC.SOL;

public class CreateMaximumNumber {
    class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int m = nums1.length, n = nums2.length;
            int[] ret = new int[k];
            for (int i = Math.max(0, k - n); i <= m && i <= k; i++) {
                int[] cand = merge(maxArray(nums1, i) , maxArray(nums2, k - i), k);
                if ( greater(cand, 0 , ret, 0 )) ret = cand;
            }
            return ret;
        }

        private int[] merge(int[] nums1, int[] nums2, int k) {
            int[] ans = new int[k];
            for (int i = 0, j = 0, r = 0; r < k; ++r)
                ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
            return ans;
        }

        boolean greater(int[] nums1, int i, int[] nums2, int j) {
            while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                i++;
                j++;
            }
            if (j == nums2.length) {
                return true;
            } else {
                return i < nums1.length && nums1[i] > nums2[j];
            }
        }

        public int[] maxArray(int[] nums, int k) {
            int n = nums.length;
            int[] ret = new int[k];
            int j = 0;
            for (int i = 0; i < n; i++) {
                while (n - i > k - j && j != 0 && nums[i] > ret[j - 1]) j--;
                if (j < k) {
                    ret[j++] = nums[i];
                }
            }
            return ret;
        }
    }
}
