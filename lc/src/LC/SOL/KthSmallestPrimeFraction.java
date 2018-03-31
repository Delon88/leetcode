package LC.SOL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KthSmallestPrimeFraction {
    static class Solution {

        public int[] kthSmallestPrimeFraction(int[] A, int K) {
            double start = (double) A[0] / (double) A[A.length - 1];
            double end = 1.0d;
            double mid = 0.0d;

            Set<Integer> number = new HashSet<>();
            for (int a : A) {
                number.add(a);
            }
            while (start + 1e-9 < end) {
                mid = (start + end) / 2;
                if (count(A, mid) >= K) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            for (int i = 0; i < A.length; i++) {
                int p = (int) Math.ceil(start * A[i]);
                if (p < A[i] && number.contains(p) && Math.abs(((double) p / A[i]) - start) <= 1e-9) {
                    return new int[]{p, A[i]};
                }
            }
            return null;
        }

        int count(int[] A, double target) {
            int count = 0;
            for (int i = 0; i < A.length; i++) {
                int low = i, high = A.length - 1;
                while (low < high) {
                    int mid = low + (high - low + 1) / 2;
                    if ((double) A[i] / A[mid] < target) {
                        high = mid - 1;
                    } else {
                        low = mid ;
                    }
                }
                if ((double) A[i] / A[low]  >= target) {
                    low = low + 1;
                }
                count += A.length - low;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5};
        System.out.println(Arrays.toString(new Solution().kthSmallestPrimeFraction(a, 3)));
    }
}
