package LC.SOL;

public class StrobogrammaticNumberIII {
    class Solution {
        int count;
        char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

        public int strobogrammaticInRange(String low, String high) {
            count = 0;
            for (int i = low.length(); i <= high.length(); i++) {
                dfs(low, high, new char[i], 0, i - 1);
            }
            return count;
        }

        void dfs(String low, String high, char[] tmp, int start, int end) {
            if (start > end) {
                String s = new String(tmp);
                if (!((s.length() == low.length() && s.compareTo(low) < 0) ||
                        (s.length() == high.length() && s.compareTo(high) > 0))) {
                    count++;
                }
                return;
            }
            for (char[] p : pairs) {
                tmp[start] = p[0];
                tmp[end] = p[1];
                if (tmp.length != 1 && tmp[0] == '0') continue;
                if ((start == end && p[0] == p[1]) || (start < end)) {
                    dfs(low, high, tmp, start + 1, end - 1);
                }
            }
        }
    }
}
