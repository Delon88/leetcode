package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StampingTheSequence {
    class Solution {
        public int[] movesToStamp(String stamp, String target) {
            char[] ta = target.toCharArray();
            char[] st = stamp.toCharArray();
            List<Integer> l = new ArrayList<>();
            for ( int i = 0 ; i < 10 * target.length() ; i++ ) {
                int index = replace(ta, st);
                if ( index != -1 ) l.add(index);
                else break;
            }
            char[] check = new char[target.length()];
            Arrays.fill(check, '*');
            if ( Arrays.equals(ta, check)) {
                Collections.reverse(l);
                int[] ret = new int[l.size()];
                for ( int i = 0 ; i < l.size(); i++) {
                    ret[i] = l.get(i);
                }
                return ret;
            } else {
                return new int[0];
            }
        }

        int replace(char[] target, char[] stamp) {
            for (int i = 0; i <= target.length - stamp.length; i++) {
                int j = 0;
                boolean found = false;
                for (; j < stamp.length; j++) {
                    if ( target[i + j] == stamp[j] ) found = true;
                    if (!(target[i + j] == '*' || target[i + j] == stamp[j])) break;
                }
                if (j == stamp.length && found) {
                    for ( int k = 0 ; k < stamp.length ; k++) target[k + i] = '*';
                    return i;
                }
            }
            return -1;
        }
    }
}
