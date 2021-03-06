package LC.SOL;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    class Solution {
        public int largestPerimeter(int[] A) {
            Arrays.sort(A);
            int n = A.length;
            for (int i = n - 1; i >= 2; i--) {
                if (A[i - 2] + A[i - 1] > A[i]) return A[i - 2] + A[i - 1] + A[i];
            }
            return 0;
        }
    }
}
