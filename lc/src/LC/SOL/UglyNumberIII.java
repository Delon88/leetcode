package LC.SOL;

public class UglyNumberIII {
    class Solution {
        public int nthUglyNumber(int n, int a, int b, int c) {
            int l = 1 , r = Integer.MAX_VALUE, mid;
            while ( l < r) {
                mid = l + ( r  - l ) /2;
                if ( count(mid, a , b , c) >=  n) r = mid;
                else l = mid + 1;
            }
            return l;
        }

        long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        long lcm(long a, long b) {
            return a * b / gcd(a, b);
        }

        long count(long n, long a, long b, long c) {
            return (int) ((n / a) + (n / b) + (n / c) - (n / lcm(a, b)) - (n / lcm(a, c)) - (n / lcm(b, c)) + (n / lcm(a, lcm(b, c))));
        }
    }
}
