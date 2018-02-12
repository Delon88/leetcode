package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels {
    class Solution {
        public List<Integer> partitionLabels(String S) {
            int[][] interval = new int[26][2];
            for (int i = 0; i < 26; i++) {
                interval[i][0] = -1;
                interval[i][1] = -1;
            }

            for (int i = 0; i < S.length(); i++) {
                int index = S.charAt(i) - 'a';
                if (interval[index][0] == -1) {
                    interval[index][0] = i;
                    interval[index][1] = i;
                } else {
                    interval[index][1] = i;
                }
            }

            Arrays.sort(interval, (a1, a2) -> a1[1] - a2[1]);
            int i = 0 ;
            for ( ; i < 26 ; i++) {
                if ( interval[i][0] != -1) break;
            }
            int end = interval[i][1];
            int start = interval[i][0];
            List<Integer> ret = new ArrayList<>();
            i++;
            for (  ;  i < 26; i++) {
                int[] inter = interval[i];
                if ( end > inter[0] ) {
                    end = inter[1];
                } else {
                    ret.add(end - start + 1);
                    end = inter[1];
                    start = inter[0];
                }
            }
            ret.add(end - start + 1);
            return ret;
        }
    }
}
