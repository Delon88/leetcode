package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    class Solution {
        public List<Integer> pancakeSort(int[] A) {
            List<Integer> ret = new ArrayList<>();
            int i = 0;
            for (int x = A.length; x > 0; x--) {
                for (i = 0; A[i] != x; i++) ;
                reverse(A, i + 1);
                ret.add(i + 1);
                reverse(A, x);
                ret.add(x);
            }
            return ret;
        }

        void reverse(int[] A, int k) {
            for (int i = 0, j = k - 1; i < j; i++, j--) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
    }
}
