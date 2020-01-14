package LC.SOL;

import java.util.*;

public class SmallestCommonRegion {
    class Solution {
        public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
            Map<String,String> pa = new HashMap<>();
            for (List<String> r : regions) {
                for( int i = 1 ; i < r.size() ; i++) {
                    pa.put(r.get(i), r.get(0));
                }
            }
            Set<String> set = new HashSet<>();
            String cur = region1;
            while ( pa.containsKey(cur)) {
                set.add(cur);
                cur = pa.get(cur);
            }
            cur = region2;
            while ( pa.containsKey(cur)) {
                if ( set.contains(cur)) return cur;
                cur = pa.get(cur);
            }
            return cur;
        }
    }
}
