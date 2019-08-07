package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    class Solution {
        public List<String> wordSubsets(String[] A, String[] B) {
            int[] count = new int[26];
            for (String b : B) {
                int[] tmp = count(b);
                for (int i = 0; i < 26; i++) {
                    count[i] = Math.max(count[i], tmp[i]);
                }
            }

            List<String> ret = new ArrayList<>();
            for (String a : A) {
                int[] tmp = count(a);
                int i = 0;
                for (i = 0; i < 26; i++) {
                    if (tmp[i] < count[i]) break;
                }
                if (i == 26) ret.add(a);
            }
            return ret;
        }

        int[] count(String s) {
            int[] c = new int[26];
            for (int i = 0; i < s.length(); i++) {
                c[s.charAt(i) - 'a']++;
            }
            return c;
        }
    }
}
