package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            Map<Character,Integer> map = new HashMap<>();
            int i = 0 , j = 0;
            int max = 0 ;
            for (  ; j < s.length() ; j++) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c , 0) + 1);
                while ( map.size() > 2) {
                    char startChar = s.charAt(i);
                    map.put(startChar, map.get(startChar) - 1);
                    if ( map.get(startChar) <= 0) { map.remove(startChar);}
                    i++;
                }
                max = Math.max(j - i + 1 , max);
            }
            return max;
        }
    }
}
