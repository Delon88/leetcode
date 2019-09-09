package LC.SOL;

public class LongestTurbulentSubarray {
    class Solution {
        public int maxTurbulenceSize(int[] A) {
            int incre = 1, decre = 1, res = 1;
            for (int k = 0; k < A.length - 1; k++) {
                if (A[k] > A[k + 1]) {
                    decre = incre + 1;
                    incre = 1;
                } else if (A[k] < A[k + 1]) {
                    incre = decre + 1;
                    decre = 1;
                } else {
                    incre = 1; decre = 1;
                }
                res = Math.max(res, Math.max(incre, decre));
            }
            return res;
        }
    }
}
