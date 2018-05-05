package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            Map<Character,Integer> map = new HashMap<>();

            int start = 0 , end = 0;
            int max = 0 ;
            for (  ; end < s.length() ; end++) {
                char c = s.charAt(end);
                map.put(c, map.getOrDefault(c , 0) + 1);
                if ( map.size() > 2) {
                    max = Math.max(end - start , max);
                    while ( map.size() > 2) {
                        char startChar = s.charAt(start);
                        map.put(startChar, map.get(startChar) - 1);
                        if ( map.get(startChar) <= 0) { map.remove(startChar);}
                        start++;
                    }
                }
            }
            max = Math.max( end - start , max);
            return max;
        }
    }
}
