package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    class Solution {
        public List<String> commonChars(String[] A) {
            int[] count = new int[26];
            Arrays.fill(count, Integer.MAX_VALUE);
            for (String a : A) {
                int[] next = new int[26];
                for (int i = 0; i < a.length(); i++) {
                    next[a.charAt(i) - 'a']++;
                }
                for (int i = 0; i < 26; i++) {
                    count[i] = Math.min(count[i], next[i]);
                }
            }
            List<String> ret = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < count[i]; j++) {
                    ret.add(Character.toString((char) (i + 'a')));
                }
            }
            return ret;
        }
    }
}
