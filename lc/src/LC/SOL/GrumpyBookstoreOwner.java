package LC.SOL;

public class GrumpyBookstoreOwner {
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {
            int w = 0, satis = 0, max = 0;
            for (int i = 0; i < customers.length; i++) {
                if (grumpy[i] == 0) satis += customers[i];
                else w += customers[i];
                if (i >= X) w -= grumpy[i - X] * customers[i - X];
                max = Math.max(max, w);
            }
            return satis + max;
        }
    }
}
