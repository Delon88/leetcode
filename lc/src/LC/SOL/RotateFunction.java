package LC.SOL;

/**
 * Created by nanhong on 12/30/2016.
 */
public class RotateFunction {
    public class Solution {
        public int maxRotateFunction(int[] A) {
            int sum = 0;
            int F = 0;
            int n = A.length;
            for (int i = 0; i < n; i++) {
                F += i * A[i];
                sum += A[i];
            }

            int max = F;
            for (int i = 1; i < n; i++) {
                F = F + sum - n * A[n - i ];
                max = Math.max(F , max);
            }
            return max;
        }
    }
}
