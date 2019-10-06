package LC.SOL;

import java.util.Arrays;

public class MaximumofAbsoluteValueExpression {
    class Solution {
        public int maxAbsValExpr(int[] A1, int[] A2) {
            int[] max = new int[4];
            Arrays.fill(max, Integer.MIN_VALUE);
            int[] min = new int[4];
            Arrays.fill(min, Integer.MAX_VALUE);
            for (int i = 0; i < A1.length; i++) {
                max[0] = Math.max(max[0], A1[i] + A2[i] + i);
                min[0] = Math.min(min[0], A1[i] + A2[i] + i);
                max[1] = Math.max(max[1], A1[i] + A2[i] - i);
                min[1] = Math.min(min[1], A1[i] + A2[i] - i);
                max[2] = Math.max(max[2], A1[i] - A2[i] + i);
                min[2] = Math.min(min[2], A1[i] - A2[i] + i);
                max[3] = Math.max(max[3], A1[i] - A2[i] - i);
                min[3] = Math.min(min[3], A1[i] - A2[i] - i);
            }
            int ret = 0;
            for ( int i = 0 ; i < 4 ;i++) ret = Math.max(ret , max[i] - min[i]);
            return ret;
        }
    }
}
