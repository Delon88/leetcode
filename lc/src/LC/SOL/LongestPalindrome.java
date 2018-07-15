package LC.SOL;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nanhong on 1/15/2017.
 */
public class LongestPalindrome {
    public class Solution {
        public int longestPalindrome(String s) {
            Set<Character> set = new HashSet<>();
            int len = s.length();
            for ( int i = 0 ; i < len ; i++) {
                if ( !set.add(s.charAt(i))) {
                    set.remove(s.charAt(i));
                }
            }
            return set.size() <= 1 ? len : len - set.size() + 1;
        }
    }
}
