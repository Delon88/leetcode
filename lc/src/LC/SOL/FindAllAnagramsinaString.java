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
            for ( int i = 0 ; i < s.length(); i++) {
                if ( count[s.charAt(i)]-- >= 1) toFind--;
                if ( toFind == 0 ) list.add(i - p.length() + 1);
                if ( i >= p.length() - 1 ) {
                    if (count[s.charAt(i - p.length() + 1)]++ >= 0 ) toFind++;
                }
            }
            return list;
        }
    }
}
