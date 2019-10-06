package LC.SOL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveVowelsfromaString {
    class Solution {

        public String removeVowels(String S) {
            StringBuilder b = new StringBuilder();
            Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
            for ( int i = 0 ; i < S.length(); i++) {
                char c = S.charAt(i);
                if ( !set.contains(c)) b.append(c);
            }
            return b.toString();
        }
    }
}
