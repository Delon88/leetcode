package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class SuperPalindromes {
    class Solution {
        public int superpalindromesInRange(String L, String R) {
            long l = Long.valueOf(L), r = Long.valueOf(R);
            int ret = 0;
            for (long i = (long) Math.sqrt(l); i * i <= r; ) {
                long p = nextP(i);
                if (p * p <= r && isPal(p * p)) {
                    ret++;
                }
                i = p + 1;
            }
            return ret;
        }

        long nextP(long num) {
            String s = Long.toString(num);
            int len = s.length();
            List<Long> cands = new ArrayList<>();
            cands.add((long) Math.pow(10, len) - 1);
            String half = s.substring(0, (len + 1) / 2);
            String nextHalf = Long.toString(Long.valueOf(half) + 1);
            String rev = new StringBuilder(half.substring(0, len / 2)).reverse().toString();
            String nextRev = new StringBuilder(nextHalf.substring(0, len / 2)).reverse().toString();
            cands.add(Long.valueOf(half + rev));
            cands.add(Long.valueOf(nextHalf + nextRev));
            long ret = Long.MAX_VALUE;
            for (long c : cands) {
                if (c >= num) {
                    ret = Math.min(ret, c);
                }
            }
            return ret;
        }

        private boolean isPal(long p) {
            String s = Long.toString(p);
            for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }
}
