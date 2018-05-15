package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
    class Solution {
        public boolean canPermutePalindrome(String s) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!set.add(c)) {
                    set.remove(c);
                }
            }
            return set.size() == 1;
        }
    }
}
