package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Boolean> ret = new ArrayList<>();
            for (String q : queries) {
                ret.add(match(q.toCharArray(), pattern.toCharArray()));
            }
            return ret;
        }

        boolean match(char[] q, char[] p) {
            int i = 0, j = 0;
            for (; i < q.length; i++) {
                if ( j < p.length && q[i] == p[j]) {
                    j++;
                } else if ( Character.isUpperCase(q[i])) {
                    return false;
                }
            }
            return j == p.length;
        }
    }
}
