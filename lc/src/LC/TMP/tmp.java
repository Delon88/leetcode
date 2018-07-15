package LC.TMP;

import java.util.ArrayList;
import java.util.List;

public class tmp {


    class Solution {
        int n, bn, cand, minlen, minab;
        List<Integer> dict;
        public String minAbbreviation(String target, String[] dictionary) {
            n = target.length(); bn = 1 << n; cand = 0; minlen = Integer.MAX_VALUE;
            dict = new ArrayList<>();
            for ( String w : dictionary ) {
                int bv = 0;
                if ( w.length() != n ) continue;
                for ( int i = 0 ; i < w.length() ; i++) {
                    if ( w.charAt(i) != target.charAt(i) ) bv |= ( 1 << i);
                }
                dict.add(bv);
                cand |= bv;
            }
            dfs(1 , 0);
            StringBuilder b = new StringBuilder();
            for(int i = 0; i < n;){
                if((minab & (1 << i)) != 0){
                    b.append(target.charAt(i++));
                }else{
                    int j = i;
                    while(i < n && (minab & (1 << i)) == 0)i++;
                    b.append(i - j);
                }
            }
            return b.toString();
        }

        void dfs(int startBit, int mask) {
            int len = getAbbrLength(mask);
            if ( len >= minlen) return;
            boolean match = true;
            for ( Integer d : dict ) {
                if ( ( mask & d ) == 0 ) {
                    match = false;
                    break;
                }
            }
            if ( match ) {
                minlen = len;
                minab = mask;
            } else {
                for ( int b = startBit ; b < bn; b <<= 1) {
                    if ( (cand & b) != 0) dfs(b << 1, mask | b);
                }
            }
        }

        // skip abbr with only one char
        int getAbbrLength(int mask) {
            int count = n;
            for ( int b = 3 ; b < bn ; b <<= 1 ) {
                if (( b &  mask) == 0 ) count--;
            }
            return count;
        }
    }
}
