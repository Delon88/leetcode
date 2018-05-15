package LC.SOL;

public class HIndexII {
    class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            for ( int i = n - 1 ; i >= 0 ; i--) {
                if ( n - i - 1 >= citations[i]) return n - i - 1;
            }
            return n;
        }
    }
}
