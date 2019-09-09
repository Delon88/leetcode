package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    class Solution {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            List<int[]> list = new ArrayList<>();
            int i = 0, j = 0;
            while (i < A.length && j < B.length) {
                int[] a = A[i], b = B[j];
                if (a[1] < b[0]) {
                    i++;
                } else if (b[1] < a[0]) {
                    j++;
                } else {
                    list.add(new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])});
                    if (a[1] < b[1]) i++;
                    else j++;
                }
            }
            int[][] ret = new int[list.size()][2];
            for (int k = 0; k < list.size(); k++) {
                ret[k] = list.get(k);
            }
            return ret;
        }
    }
}
