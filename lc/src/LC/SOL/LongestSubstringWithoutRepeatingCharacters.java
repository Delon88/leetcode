package LC.SOL;

public class LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            boolean[] e = new boolean[256];
            int start = 0, end = 0;
            int max = 0;
            while ( end < s.length()) {
                if ( e[s.charAt(end)]) {
                    max = Math.max( end - start, max);
                    while ( start < end && s.charAt(start) != s.charAt(end)) {
                        e[s.charAt(start)] = false;
                        start++;
                    }
                    start++;
                } else {
                    e[s.charAt(end)] = true;
                }
                end++;
            }
            max = Math.max( end - start, max);
            return max;
        }
    }
}
