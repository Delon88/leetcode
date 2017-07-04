package LC.SOL;

/**
 * Created by nanhong on 12/12/2016.
 */
public class EliminationGame {
    public class Solution {
        public int lastRemaining(int n) {
            return n == 1 ? 1 : 2 * ( 1 + n / 2 - lastRemaining(n / 2));
        }
    }
}
