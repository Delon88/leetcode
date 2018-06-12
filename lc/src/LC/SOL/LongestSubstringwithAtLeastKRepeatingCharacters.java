package LC.SOL;

public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public class Solution {
        public int longestSubstring(String s, int k) {
            return dc(s, 0, s.length(), k);
        }

        public int dc(String s, int start, int end, int k) {
            if (end - start < k) return 0;
            int[] count = new int[26];
            for (int i = start; i < end; i++) {
                count[s.charAt(i) - 'a']++;
            }
            for (int i = start; i < end; i++) {
                if ( count[s.charAt(i) - 'a'] < k ) {
                    return Math.max(dc( s , start , i , k) , dc( s , i + 1 , end , k ));
                }
            }
            return end - start;
        }
    }
}
