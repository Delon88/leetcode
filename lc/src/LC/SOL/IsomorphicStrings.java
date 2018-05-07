package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if ( s.length() != t.length() ) return false;
            Map<Character,Character> forward = new HashMap<>();
            Set<Character> backward = new HashSet<>();
            for ( int i = 0 ;i < s.length() ; i++) {
                char c1 = s.charAt(i), c2 = t.charAt(i);
                if ( !forward.containsKey(c1) ) {
                    if ( !backward.contains(c2)) {
                        forward.put(c1, c2);
                        backward.add(c2);
                    } else {
                        return false;
                    }
                } else {
                    if ( forward.get(c1) != c2 ) return false;
                }
            }
            return true;
        }
    }
}
