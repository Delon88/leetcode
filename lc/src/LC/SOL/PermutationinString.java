package LC.SOL;

import java.util.Arrays;

/**
 * Created by nanhong on 9/5/2017.
 */
public class PermutationinString {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            if (len1 > len2) return false;
            int[] count = new int[26];
            int[] zeros = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                count[s1.charAt(i) - 'a']++;
            }

            for (int i = 0; i < len2; i++) {
                count[s2.charAt(i) - 'a']--;
                if (i - len1 >= 0) count[s2.charAt(i - len1) - 'a']++;
                if (Arrays.equals(count, zeros)) return true;
            }
            return false;
        }
    }
}
