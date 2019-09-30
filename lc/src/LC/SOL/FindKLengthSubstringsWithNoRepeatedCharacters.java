package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class FindKLengthSubstringsWithNoRepeatedCharacters {
    class Solution {
        public int numKLenSubstrNoRepeats(String S, int K) {
            Set<Character> set = new HashSet<>();
            int ret = 0, i = 0;
            for (int j = 0; j < S.length(); j++) {
                while ( set.contains(S.charAt(j))) {
                    set.remove(S.charAt(i++));
                }
                set.add(S.charAt(j));
                ret += ( j - i + 1 ) >= K ? 1 : 0;
            }
            return ret;
        }
    }
}
