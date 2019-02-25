package LC.SOL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GroupsofSpecialEquivalentStrings {
    class Solution {
        public int numSpecialEquivGroups(String[] A) {
            Set<String> set = new HashSet<>();
            for ( String a : A) {
                int[] odd = new int[26];
                int[] even = new int[26];
                for ( int i = 0 ; i < a.length(); i++) {
                    if ( i % 2 == 0 ) {
                        even[a.charAt(i) - 'a']++;
                    } else {
                        odd[a.charAt(i) - 'a']++;
                    }
                }
                String sig = Arrays.toString(odd) + Arrays.toString(even);
                set.add(sig);
            }
            return set.size();
        }
    }
}
