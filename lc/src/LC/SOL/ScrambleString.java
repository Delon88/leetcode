package LC.SOL;

public class ScrambleString {
    class Solution {
        public boolean isScramble(String s1, String s2) {
            if (s1.equals(s2)) return true;
            if (s1.length() != s2.length()) return false;
            int sum1 = 0, sum2 = 0;
            int[] count = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                count[s1.charAt(i) - 'a']++;
                count[s2.charAt(i)- 'a']--;
            }
            for ( int i : count) {if ( i != 0 ) return false;}
            if ( sum1 != sum2 ) return false;
            for (int i = 1; i < s1.length(); i++) {
                // case1
                if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                        || (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))))
                    return true;
            }
            return false;
        }
    }
}
