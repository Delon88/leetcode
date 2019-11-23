package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int i  = 0 , j = 0;
            Set<Character> set = new HashSet<>(s.length());
            int max = 0 ;
            for( ; j < s.length() ; j++) {
                char c = s.charAt(j);
                while ( set.contains(c) && i < j ) {
                    set.remove(s.charAt(i++));
                }
                max = Math.max(max , j - i + 1);
                set.add(c);
            }
            return max;
        }
    }
}
