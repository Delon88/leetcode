package LC.SOL;

import java.util.Arrays;

public class HIndex {
    class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] buckets = new int[n + 1];
            for (int c : citations) {
                if (c >= n) {
                    buckets[n]++;
                } else {
                    buckets[c]++;
                }
            }
            int count = 0;
            for (int i = n; i >= 0; i--) {
                count += buckets[i];
                if (count >= i) {
                    return i;
                }
            }
            return 0;
        }
    }

    class Solution1 {
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
