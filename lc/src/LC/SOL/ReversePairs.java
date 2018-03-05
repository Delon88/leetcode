package LC.SOL;

import java.util.Arrays;

public class ReversePairs {
    static class Solution {
        public int reversePairs(int[] nums) {
            int[] copy = Arrays.copyOf(nums, nums.length);
            int[] bit = new int[copy.length + 1];
            Arrays.sort(copy);
            int ret = 0;
            for ( int e : nums) {
                ret+= getSum(bit, index( copy,2 * e  + 1));
                insert(bit, index(copy, e));
            }
            return ret;
        }

        public int getSum(int[] bit, int i) {
            int sum = 0;
            while (i < bit.length) {
                sum += bit[i];
                i += i & -i;
            }
            return sum;
        }

        public void insert(int[] bit, int i) {
            while (i > 0) {
                bit[i] += 1;
                i -= i & -i;
            }
        }

        public int index(int[] arr, long value) {
            int start = 0, end = arr.length - 1, mid = 0;
            while (start <= end) {
                mid = start + ((end - start) >> 1);
                if (arr[mid] >= value) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return start + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 8, 2, 3, 1, 3};
        new Solution().reversePairs(nums);
    }
}
