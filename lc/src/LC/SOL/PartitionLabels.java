package LC.SOL;

import java.util.*;

public class PartitionLabels {
    class Solution {
        public List<Integer> partitionLabels(String S) {
            Map<Character,Integer> last = new HashMap<>();
            for ( int i = 0 ; i < S.length() ; i++) {
                char c = S.charAt(i);
                last.put(c, i);
            }

            int start = 0 ;
            int end = 0;
            List<Integer> ret = new ArrayList<>();
            for ( int i = 0 ; i < S.length() ; i++)  {
                char c = S.charAt(i);
                end = Math.max(end, last.get(c));
                if ( i == end) {
                    ret.add( end - start + 1);
                    start = end + 1;
                }
            }
            return ret;
        }
    }
}
