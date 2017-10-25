package LC.SOL;

public class FindtheDerangementofAnArray {
    class Solution {

        private static final int M = 1000000007;

        public int findDerangement(int n) {
            // n!= ( n - 1) * ( (n - 1)!  )
            long ret = 1;
            for (int i = 1; i <= n; i++) {
                ret = (((ret * i) % M) + (i % 2 == 0 ? 1 : -1)) % M;
            }
            return (int) ret;
        }
    }
}
