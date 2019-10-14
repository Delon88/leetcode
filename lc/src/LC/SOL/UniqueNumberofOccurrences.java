package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberofOccurrences {
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer,Integer> map = new HashMap<>();
            for ( int a : arr) map.put(a , map.getOrDefault(a , 0) + 1);
            Set<Integer> set = new HashSet<>();
            for ( int v : map.values()) {
                if ( !set.add(v)) return false;
            }
            return true;
        }
    }
}
