package LC.SOL;

public class ReachaNumber {
    class Solution {
        public int reachNumber(int target) {
            long t = Math.abs(target);
            long n = (long) Math.ceil((-1.0 + Math.sqrt(t * 8 + 1)) / 2);
            long sum = n * (n + 1) / 2;
            if (sum == t) return (int) n;
            long diff = sum - t;
            if ((diff & 1) == 0) return (int) n;
            else return (int) (n + ((n & 1) == 1 ? 2 : 1));
        }
    }
}
