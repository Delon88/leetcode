package LC.SOL;

public class WildcardMatching {
    class Solution {
        public boolean isMatch(String s, String p) {
            int sCur = 0;
            int pCur = 0;
            int lastStar = -1;
            int lastMatch = 0;
            while ( sCur < s.length() ) {
                if ( pCur < p.length() && (p.charAt(pCur) == '?' || s.charAt(sCur) == p.charAt(pCur))) {
                    sCur++;
                    pCur++;
                } else if ( pCur < p.length() && p.charAt(pCur) == '*' ) {
                    lastMatch = sCur;
                    lastStar = pCur;
                    pCur++;
                } else if ( lastStar != -1 ) {
                    pCur = lastStar + 1;
                    sCur = lastMatch + 1;
                    lastMatch++;
                } else {
                    return false;
                }
            }

            while ( pCur < p.length() && p.charAt(pCur) == '*') pCur++;

            return pCur == p.length();
        }
    }
}
