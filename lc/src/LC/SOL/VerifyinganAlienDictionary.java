package LC.SOL;

public class VerifyinganAlienDictionary {
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int size = order.length();
            int[] or = new int[size];
            for ( int i = 0 ; i < order.length() ; i++) or[order.charAt(i) - 'a'] = i;
            outter:
            for (int i = 0; i < words.length - 1; i++) {
                String s1 = words[i], s2 = words[i + 1];
                int m = 0, n = 0;
                for (; m < s1.length() && n < s2.length(); m++, n++) {
                    if ( or[s1.charAt(m) - 'a'] > or[s2.charAt(n) - 'a'] ) return false;
                    else if ( or[s1.charAt(m) - 'a'] < or[s2.charAt(n) - 'a'] ) continue outter;
                }
                if ( s1.length() > s2.length()) return false;
            }
            return true;
        }
    }
}
