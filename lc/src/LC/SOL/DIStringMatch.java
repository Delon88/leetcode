package LC.SOL;

public class DIStringMatch {
    class Solution {
        public int[] diStringMatch(String S) {
            int n = S.length(), left = 0, right = n;
            int[] ret = new int[n + 1];
            for (int i = 0; i < S.length(); i++) {
                ret[i] = S.charAt(i) == 'I' ? left++ : right--;
            }
            ret[n] = left;
            return ret;
        }
    }
}
