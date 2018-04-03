package LC.SOL;

public class KthSmallestinLexicographicalOrder {
    class Solution {
        public int findKthNumber(int n, int k) {
            int cur = 1;
            k--;
            while (k > 0) {
                int steps = calSteps(n, cur, cur + 1);
                if (steps <= k) {
                    k -= steps;
                    cur = cur + 1;
                } else {
                    k--;
                    cur *= 10;
                }
            }
            return cur;
        }

        int calSteps(int n, long n1, long n2) {
            int steps = 0;
            while (n1 <= n) {
                if (n >= n2) {
                    steps += n2 - n1;
                } else {
                    steps += n + 1 - n1;
                }
                n1 *= 10;
                n2 *= 10;
            }
            return steps;
        }
    }


}
