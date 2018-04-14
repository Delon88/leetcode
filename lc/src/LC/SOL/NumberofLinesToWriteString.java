package LC.SOL;

public class NumberofLinesToWriteString {
    class Solution {
        public int[] numberOfLines(int[] widths, String S) {
            if ( S.length() == 0) return new int[]{0 , 0};
            int count = 1;
            int cur = 0;
            for (int i = 0; i < S.length(); i++) {
                int w = widths[S.charAt(i) - 'a'];
                if (cur + w <= 100) {
                    cur += w;
                } else {
                    count++;
                    cur = w;
                }
            }
            return new int[]{count, cur};
        }
    }
}
