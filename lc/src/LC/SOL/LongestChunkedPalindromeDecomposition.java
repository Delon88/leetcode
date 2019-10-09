package LC.SOL;

public class LongestChunkedPalindromeDecomposition {
    class Solution {
        public int longestDecomposition(String text) {
            int ret = 0, n = text.length();
            String l = "", r = "";
            for (int i = 0; i < n ; i++) {
                l = l + text.charAt(i);
                r = text.charAt(n - 1 - i) + r;
                if (l.equals(r)) {
                    ret++; l = ""; r = "";
                }
            }
            return ret == 0 ? 1 : ret;
        }
    }
}
