package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (k <= 0) return 0;
            Map<Character, Integer> map = new HashMap<>();
            int max = 0, i = 0, start = 0;
            for (; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                while (map.size() > k) {
                    char sChar = s.charAt(start++);
                    map.put(sChar, map.get(sChar) - 1);
                    if (map.get(sChar) == 0) map.remove(sChar);
                }
                max = Math.max(max, i - start + 1);
            }
            return max;
        }
    }
}
