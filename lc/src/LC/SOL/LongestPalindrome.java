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
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (set.contains(c)) {
                    set.remove(c);
                } else {
                    set.add(c);
                }
            }
            return s.length() - (set.size() <= 1 ? 0: set.size() - 1);
        }
    }
}
