package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    class Solution {
        public List<String> letterCasePermutation(String S) {
            char[] a = S.toCharArray();
            List<String> ret = new ArrayList<>();
            solve(a, 0, ret);
            return ret;
        }

        void solve(char[] a, int start, List<String> ret) {
            if (a.length == start) {
                ret.add(new String(a));
                return;
            }
            if (Character.isLetter(a[start])) {
                a[start] = Character.toLowerCase(a[start]);
                solve(a, start + 1, ret);
                a[start] = Character.toUpperCase(a[start]);
                solve(a, start + 1, ret);
            } else {
                solve(a, start + 1, ret);
            }
        }
    }
}
