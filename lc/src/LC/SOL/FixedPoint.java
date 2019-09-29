package LC.SOL;

public class FixedPoint {
    class Solution {
        public int fixedPoint(int[] A) {
            int start = 0, end = A.length -1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if ( A[mid] >= mid) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return A[start] == start ? start: -1;
        }
    }
}
