package LC.SOL;

public class BeautifulArrangementII {
    class Solution {
        public int[] constructArray(int n, int k) {
            int[] ret = new int[n];
            for (int i = 0 , l = 1 , r = n ; i < n; i++) {
                if ( k > 1 ) {
                    ret[i] = k % 2 == 0 ? r-- : l++;
                    k--;
                } else {
                    ret[i] = l++;
                }
            }
            return ret;
        }
    }
}
