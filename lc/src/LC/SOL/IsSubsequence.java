package LC.SOL;

/**
 * Created by nanhong on 12/12/2016.
 */
public class IsSubsequence {
    public class Solution {
        public boolean isSubsequence(String s, String t) {
//            if (s.length() == 0) return true;
//            int indexS = 0, indexT = 0;
//            while (indexT < t.length()) {
//                if (t.charAt(indexT) == s.charAt(indexS)) {
//                    indexS++;
//                    if (indexS == s.length()) return true;
//                }
//                indexT++;
//            }
//            return false;
            if ( s.length() == 0 ) return true;
            int sIndex = 0 , tIndex = 0 ;
            while ( tIndex < t.length()) {
                if ( t.charAt(tIndex) == s.charAt(sIndex)) {
                    sIndex++;
                    if ( sIndex == s.length()) return true;
                }
                tIndex++;
            }
            return false;
        }
    }
}
