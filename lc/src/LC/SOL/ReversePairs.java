package LC.SOL;

import java.util.Arrays;

public class ReversePairs {
    static class Solution {
        public int reversePairs(int[] nums) {
            int[] copy = Arrays.copyOf(nums, nums.length);
            int[] bit = new int[copy.length + 1];
            Arrays.sort(copy);
            int ret = 0;
            for (int e : nums) {
                ret += getSum(bit, index(copy, 2 * e + 1));
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

    static class Solution1 {
        public int reversePairs(int[] nums) {
            return mergeSort(nums, 0, nums.length - 1);
        }

        int mergeSort(int[] nums, int start, int end) {
            if (start >= end) return 0;
            int mid = start + ((end - start) / 2);
            int ret = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
            int[] merge = new int[end - start + 1];
            int i = start, j = mid + 1, k = 0, p = mid + 1;
            while (i <= mid) {
                while (p <= end && nums[i] > 2L * nums[p]) p++;
                ret += p - (mid + 1);
                while (j <= end && nums[i] >= nums[j]) { merge[k++] = nums[j++];}
                merge[k++] = nums[i++];
            }

            while (j <= end) merge[k++] = nums[j++];
            System.arraycopy(merge, 0, nums, start, merge.length);
            return ret;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1};
        new Solution1().reversePairs(nums);
    }
}
