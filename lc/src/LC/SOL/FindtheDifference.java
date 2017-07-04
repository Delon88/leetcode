package LC.SOL;

/**
 * Created by nanhong on 12/12/2016.
 */
public class FindtheDifference {
    public class Solution {
        public char findTheDifference(String s, String t) {
            char c = 0;
            for ( int i = 0 ; i < s.length() ; i++) {
                c ^= s.charAt(i);
            }
            for ( int i = 0 ; i < t.length() ; i++) {
                c ^= t.charAt(i);
            }
            return c;
        }
    }
}
