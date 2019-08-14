package LC.SOL;

public class FlipStringtoMonotoneIncreasing {
    class Solution {
        // find first 1
        //
        public int minFlipsMonoIncr(String S) {
            int flipCount = 0;
            int counterOne = 0;
            for (int i = 0; i < S.length(); i++) {
                if ( S.charAt(i) == '1') {
                    counterOne++;
                } else {
                    flipCount++;
                }
                flipCount = Math.min(flipCount, counterOne);
            }
            return flipCount;
        }
    }
}
