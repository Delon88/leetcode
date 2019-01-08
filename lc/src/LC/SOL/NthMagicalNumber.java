package LC.SOL;

public class NthMagicalNumber {
    class Solution {
        public int nthMagicalNumber(int N, int A, int B) {
            long a = A, b = B, tmp;
            while (b > 0) {
                tmp = a;
                a = b;
                b = tmp % b;
            }
            long l = 2, r = (long) 1e14, m = 0, mod = (long) 1e9 + 7;
            while (l < r) {
                m = (l + r) / 2;
                if (m / A + m / B - m / (A * B / a) >= N) r = m;
                else l = m + 1;
            }
            return (int) (l % mod);
        }
    }
}
