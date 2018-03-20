package LC.SOL;

public class KthSmallestNumberinMultiplicationTable {
    class Solution {
        //
//        1 	2 	3
//        2	    4	6
        public int findKthNumber(int m, int n, int k) {
            int low = 1, high = m * n + 1, mid;

            while (low < high) {
                mid = low + ((high - low) >> 1);
                if (count(mid, m, n) >= k) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return high;
        }

        int count(int v, int m, int n) {
            int c = 0;
            for (int i = 1; i <= m; i++) {
                c += Math.min(v / i, n);
            }
            return c;
        }
    }
}
