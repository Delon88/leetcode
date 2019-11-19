package LC.SOL;

public class MissingNumberInArithmeticProgression {
    class Solution {
        public int missingNumber(int[] A) {
            int first = A[0], last = A[0], sum = 0, n = A.length;
            for (int a : A) {
                first = Math.min(first, a);
                last = Math.max(last, a);
                sum += a;
            }
            return (first + last) * (n + 1) / 2 - sum;
        }
    }

    class Solution1 {
        public int missingNumber(int[] A) {
            int n = A.length, d = (A[n - 1] - A[0]) / n, left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (A[mid] == A[0] + d * mid)
                    left = mid + 1;
                else
                    right = mid;
            }
            return A[0] + d * left;
        }
    }
}
