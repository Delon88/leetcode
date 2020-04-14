package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class DistinctEchoSubstrings {
    class Solution {
        public int distinctEchoSubstrings(String text) {
            Set<String> set = new HashSet<>();
            int n = text.length();
            for (int i = 0; i < n; i++) {
                for (int len = 2; i + len <= n; len += 2) {
                    int mid = i + len / 2;
                    String s1 = text.substring(i , mid);
                    String s2 = text.substring(mid, i + len);
                    if ( s1.equals(s2)) set.add(s1);
                }
            }
            return set.size();
        }
    }

    class SolutionHash {

    }
}
