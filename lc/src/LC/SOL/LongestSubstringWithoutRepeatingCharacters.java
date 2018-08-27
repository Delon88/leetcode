package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length()==0) return 0;
            Map<Character, Integer> map = new HashMap<>();
            int max=0;
            for ( int start = 0 , end = 0 ; end < s.length() ; end++) {
                if ( map.containsKey(s.charAt(end))) {
                    start = Math.max(start , map.get(s.charAt(end)) + 1);
                }
                map.put(s.charAt(end) , end);
                max = Math.max(end - start + 1 , max);
            }
            return max;
        }
    }
}
