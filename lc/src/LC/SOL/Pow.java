package LC.SOL;

public class Pow {
    class Solution {
        public double myPow(double x, int n) {
            if ( n == 0 ) return 1;
            if ( n < 0 ) return 1.0d / pow(x , -n);
            return pow(x, n);
        }

        double pow(double x, int n ) {
            if ( n == 0 ) return 1;
            if ( n == 1) return x;
            double p = pow(x , n  / 2);
            if ( n % 2 == 0) return p * p;
            else return p * p * x;
        }
    }
}
