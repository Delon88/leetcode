package LC.SOL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindtheClosestPalindrome {
    static class Solution {
        public String nearestPalindromic(String n) {
            if(n.length()==1){
                return String.valueOf(Integer.parseInt(n)-1);
            }
            int len = n.length();
            List<Long> cands = new ArrayList<>();
            cands.add(getNines(len -1));
            cands.add(getNines( len));
            cands.add(getOneZero(len));
            cands.add(getOneZero(len + 1));
            int halfLen = ( len + 1) / 2;

            getCands(cands, Long.parseLong(n.substring(0 , halfLen)), len);

            long minDiff = Long.MAX_VALUE;
            long num = Long.parseLong(n);
            long ret = -1l;
            Collections.sort(cands);
            for ( Long c : cands) {
                if (c == num) continue;
                if ( Math.abs(c - num) < minDiff) {
                    minDiff = Math.abs(c - num);
                    ret = c;
                }
            }
            return Long.toString(ret);
        }

        void getCands(List<Long> cands, long firsthalf, int len ) {
            List<Long> tmp = new ArrayList<>();
            tmp.add(firsthalf);
            tmp.add(firsthalf - 1);
            tmp.add(firsthalf + 1);
            for ( Long c : tmp) {
                String cStr = Long.toString(c);
                if ( len % 2 == 0 ) {
                    long pal = Long.parseLong(c + new StringBuilder(cStr).reverse().toString());
                    cands.add(pal);
                } else {
                    long pal = Long.parseLong( c + new StringBuilder(cStr.substring(0 , cStr.length() -1)).reverse().toString());
                    cands.add(pal);
                }
            }
        }

        long getNines(int n) {
            return ((long) Math.pow(10 , n)) - 1l;
        }

        long getOneZero(int n ) {
            return (long)(Math.pow(10, n)) + 1l;
        }
    }
}
