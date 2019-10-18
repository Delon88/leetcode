package LC.SOL;

public class PlaywithChips {
    class Solution {
        public int minCostToMoveChips(int[] chips) {
            int odd = 0, even = 0;
            for ( int i = 0 ; i < chips.length ; i++) {
                if ( chips[i] % 2 == 0 ) even += 1;
                else odd += 1;
            }
            return Math.min(even , odd);
        }
    }
}
