package LC.SOL;

/**
 * Created by nanhong on 12/11/2016.
 */
public class RansomNote {
    public class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if ( ransomNote.length() == 0 ) return true;
            int[] count = new int[26];
            int total = 0;
            for (int i = 0; i < ransomNote.length(); i++) {
                count[ransomNote.charAt(i) - 'a']++;
                total++;
            }
            for (int i = 0; i < magazine.length(); i++) {
                if ( count[ magazine.charAt(i) - 'a'] != 0 ) {
                    count[magazine.charAt(i) - 'a']--;
                    total--;
                    if ( total == 0 ) return true;
                }
            }
            return false;
        }
    }
}
