package LC.SOL;

public class OneEditDistance {
    class Solution {
        public boolean isOneEditDistance(String s, String t) {
            if ( s.length() > t.length() ) return isOneEditDistance(t , s);
            if ( Math.abs(s.length() - t.length()) > 1 || s.equals(t) ) return false;
            int i = 0, j = 0;
            while ( i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            if ( s.length() != t.length() ) {j++;}
            else {i++;j++;}

            while ( i < s.length() && j < t.length() ) {
                if ( s.charAt(i) != t.charAt(j)) return false;
                i++;j++;
            }
            return true;
        }
    }
}
