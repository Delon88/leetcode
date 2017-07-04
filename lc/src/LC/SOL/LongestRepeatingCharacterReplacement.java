package LC.SOL;

/**
 * Created by nanhong on 1/29/2017.
 */
public class LongestRepeatingCharacterReplacement {
    public class Solution {
        public int characterReplacement(String s, int k) {
            int[] count = new int[26];
            int max = 0, start = 0;
            for (int end = 0; end < s.length(); end++) {
                max = Math.max(max, ++count[s.charAt(end) - 'A']);
                if (max + k <= end - start) {
                    count[s.charAt(start++) - 'A']--;
                }
            }
            return s.length() - start;
        }
    }
}
