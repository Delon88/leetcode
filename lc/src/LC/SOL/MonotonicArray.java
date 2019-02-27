package LC.SOL;

public class MonotonicArray {
    class Solution {
        public boolean isMonotonic(int[] A) {
            boolean inc = true, dec = true;
            for (int i = 0; i < A.length - 1; i++) {
                inc &= A[i] <= A[i + 1];
                dec &= A[i] >= A[i + 1];
            }
            return inc || dec;
        }
    }
}
