package LC.SOL;

public class ReachaNumber {
    class Solution {
        public int reachNumber(int target) {
            target = Math.abs(target);
            long n =  (long) Math.ceil(Math.sqrt(1.0d / 4.0d + 2.0d * target) - 1.0d / 2.0d);
            long sum = n * ( n + 1) / 2;
            long diff = sum - target;
            if ( diff == 0) return (int) n;
            else if ( diff)
        }
    }
}
