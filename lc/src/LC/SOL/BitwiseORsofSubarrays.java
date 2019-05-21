package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsofSubarrays {
    class Solution {
        public int subarrayBitwiseORs(int[] A) {
            Set<Integer> cur = new HashSet<>();
            Set<Integer> next;
            Set<Integer> ret = new HashSet<>();
            for ( int i : A ) {
                next = new HashSet<>();
                next.add(i);
                for ( int c : cur ) {
                    next.add( c | i);
                }
                ret.addAll(next);
                cur = next;
            }
            return ret.size();
        }
    }
}
