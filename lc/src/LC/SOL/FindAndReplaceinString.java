package LC.SOL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAndReplaceinString {
    class Solution {
        public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
            List<int[]> sorted = new ArrayList<>();
            for ( int i = 0 ;i < indexes.length ; i++) sorted.add(new int[]{indexes[i] , i });
            Collections.sort(sorted, (i1, i2) -> i2[0] - i1[0]);
            for ( int[] ind : sorted ) {
                int i = ind[0] , j = ind[1];
                String sr = sources[j] , t = targets[j];
                if ( S.substring(i, i + sr.length()).equals(sr)) S = S.substring(0, i) + t + S.substring(i + sr.length());
            }
            return S;
        }
    }
}
