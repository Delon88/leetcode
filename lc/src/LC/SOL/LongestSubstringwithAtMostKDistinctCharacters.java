package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if ( k <= 0 ) return 0;
            Map<Character, Integer> map = new HashMap<>();
            int max = 0, i = 0, start = 0;
            for ( ; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    max = Math.max(max, i - start);
                    while ( map.size() >= k ) {
                        char sChar = s.charAt(start++);
                        map.put( sChar, map.get(sChar) -1 );
                        if ( map.get(sChar) == 0 ) {map.remove(sChar);}
                    }
                    map.put( c , 1);
                }
            }
            max = Math.max(max,  i - start );
            return max;
        }
    }
}
