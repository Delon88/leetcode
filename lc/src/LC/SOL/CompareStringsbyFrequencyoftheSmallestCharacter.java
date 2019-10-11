package LC.SOL;

import java.util.Arrays;

public class CompareStringsbyFrequencyoftheSmallestCharacter {
    class Solution {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int[] w = new int[words.length];
            for ( int i = 0; i < words.length; i++) w[i] = f(words[i]);
            Arrays.sort(w);
            int[] ret = new int[queries.length];
            for ( int i = 0; i < queries.length ; i++) {
                int f = f(queries[i]);
                int l = 0, r = w.length - 1;
                while ( l < r) {
                    int mid = ( l + r)/ 2;
                    if ( w[mid] > f ) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                if ( !(w[l] > f) ) ret[i] = 0;
                else ret[i] = w.length - l;
            }
            return ret;
        }

        int f(String s) {
            if ( s.length() == 0) return 0;
            int[] a = new int[26];
            for ( int i = 0 ; i < s.length() ; i++) {
                a[s.charAt(i) - 'a']++;
            }
            for ( int i = 0; i < 26 ; i++) {
                if ( a[i] > 0 ) return a[i];
            }
            return 0;
        }
    }
}
