package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for ( int n : nums ) {
                if ( !set.add(n) ) return true;
            }
            return false;
        }
    }
}
