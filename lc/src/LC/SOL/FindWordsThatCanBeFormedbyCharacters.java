package LC.SOL;

public class FindWordsThatCanBeFormedbyCharacters {
    class Solution {
        public int countCharacters(String[] words, String chars) {
            int[] c = new int[26];
            for (char ch : chars.toCharArray()) c[ch - 'a']++;
            int ret = 0;
            for (String w : words) {
                int[] t = new int[26];
                for (char ch : w.toCharArray()) t[ch - 'a']++;
                int i = 0;
                for (; i < 26; i++) {
                    if ( t[i] > c[i]) break;
                }
                ret += i == 26 ? w.length() : 0;
            }
            return ret;
        }
    }
}
