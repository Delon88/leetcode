package LC.SOL;

import java.util.Arrays;

public class SumofMutatedArrayClosesttoTarget {
    class Solution {
        public int findBestValue(int[] arr, int target) {
            Arrays.sort(arr);
            int start = 0, end = 0, sum = 0;
            for (int i : arr) {
                end = Math.max(end, i);
                sum += i;
            }

            if (sum <= target)
                return end;
            while (start < end) {
                int mid = (start + end) / 2;
                if (getSum(arr, mid) >= target)
                    end = mid;
                else
                    start = mid + 1;
            }
            int s1 = getSum(arr, start - 1);
            int s2 = getSum(arr, start);
            return (Math.abs(s1 - target) <= Math.abs(s2 - target)) ? start - 1 : start;
        }

        int getSum(int[] arr, int v) {
            int sum = 0;
            for (int i : arr) {
                sum += (i > v ? v : i);
            }
            return sum;
        }
    }
}