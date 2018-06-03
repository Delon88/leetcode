package LC.SOL;

public class RangeAddition {
    class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            int[] ret = new int[length];
            for ( int[] u : updates) {
                int start = u[0], end = u[1], val = u[2];
                ret[start]+= val;
                if ( end < length - 1) {
                    ret[end + 1] -= val;
                }
            }
            int sum = 0 ;
            for ( int i = 0 ;i < ret.length ;i++) {
                sum += ret[i];
                ret[i] = sum;
            }
            return ret;
        }
    }
}
