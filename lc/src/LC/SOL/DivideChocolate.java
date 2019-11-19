package LC.SOL;

public class DivideChocolate {
    class Solution {
        public int maximizeSweetness(int[] sweetness, int K) {
            int l = 1, r = (int) 1e9 / (K + 1);
            while (l < r) {
                int mid = (l + r + 1) / 2;
                int cur = 0, cuts = 0;
                for (int s : sweetness) {
                    if ((cur += s) >= mid) {
                        cur = 0;
                        if (++cuts > K) break;
                    }
                }
                if (cuts < K + 1) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            return l;
        }
    }
}
