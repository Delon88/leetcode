package LC.SOL;

public class ShortestDistancetoaCharacter {
    class Solution {
        public int[] shortestToChar(String S, char C) {
            int[] ret = new int[S.length()];
            int n = S.length();
            for (int i = 0; i < n; i++) {
                ret[i] = S.charAt(i) == C ? 0 : n;
            }
            for (int i = 1; i < n; i++) {
                ret[i] = Math.min(ret[i], ret[i - 1] + 1);
            }
            for (int i = n - 2; i >= 0; i--) {
                ret[i] = Math.min(ret[i], ret[i + 1] + 1);
            }
            return ret;
        }
    }
}
