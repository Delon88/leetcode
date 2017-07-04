package LC.SOL;

/**
 * Created by nanhong on 1/15/2017.
 */
public class ArithmeticSlices {
    public class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            int cur = 0, sum = 0;
            for (int i = 2; i < A.length; i++) {
                if ( A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                    cur++;
                    sum = sum + cur;
                } else  {
                    cur = 0 ;
                }
            }
            return sum;
        }
    }
}
