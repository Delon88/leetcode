package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {
    public class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int toFind = p.length();
            List<Integer> list = new ArrayList<>();
            int[] count = new int[256];
            for ( int i = 0  ; i < p.length() ; i++) {
                count[p.charAt(i)]++;
            }
            int start = 0 , end = 0;
            while ( end < s.length()) {
                if ( count[s.charAt(end)] >= 1 ) toFind--;
                count[s.charAt(end)]--;
                end++;
                if ( toFind == 0 ) list.add(start);
                if ( end - start == p.length() ) {
                    if ( count[s.charAt(start)] >= 0 ) {
                        toFind++;
                    }
                    count[s.charAt(start)]++;
                    start++;
                }
            }
            return list;
        }
    }
}
