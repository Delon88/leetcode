package LC.SOL;

import java.util.Arrays;

public class HeightChecker {
    class Solution {
        public int heightChecker(int[] heights) {
            int[] clone = heights.clone();
            Arrays.sort(clone);
            int ret =0;
            for ( int i =0 ;i < heights.length ; i++) {
                if ( heights[i] != clone[i]) ret++;
            }
            return ret;
        }
    }
}
