package LC.SOL;

import java.util.Arrays;

public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public class Solution {
        public int longestSubstring(String s, int k) {
            char[] str = s.toCharArray();
            int[] counts = new int[26];
            int h, i, j, idx, max = 0, unique, noLessThanK;

            for (h = 1; h <= 26; h++) {
                Arrays.fill(counts, 0);
                i = 0;
                j = 0;
                unique = 0;
                noLessThanK = 0;
                while (j < str.length) {
                    if (unique <= h) {
                        idx = str[j] - 'a';
                        if (counts[idx] == 0)
                            unique++;
                        counts[idx]++;
                        if (counts[idx] == k)
                            noLessThanK++;
                        j++;
                    }
                    else {
                        idx = str[i] - 'a';
                        if (counts[idx] == k)
                            noLessThanK--;
                        counts[idx]--;
                        if (counts[idx] == 0)
                            unique--;
                        i++;
                    }
                    if (unique == h && unique == noLessThanK)
                        max = Math.max(j - i, max);
                }
            }

            return max;
        }
    }

    class Solution1 {
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
