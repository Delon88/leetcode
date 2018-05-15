package LC.SOL;

import java.util.Arrays;

public class HIndex {
    class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int n = citations.length;

            for( int i =  n - 1; i >= 0  ; i--) {
                if ( n - i - 1 >= citations[i]) return n - i - 1;
            }
            return n;
        }
    }
}
