package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class CrackingtheSafe {

    //    Example 1:
//
//    Input: n = 1, k = 2
//    Output: "01"
//    Note: "10" will be accepted too.
//
//    Example 2:
//
//    Input: n = 2, k = 2
//    Output: "00110"
//    Note: "01100", "10011", "11001" will be accepted too.
//
//    Note:
//
//    n will be in the range [1, 4].
//    k will be in the range [1, 10].
//    k^n will be at most 4096.
//    n = 3 , k = 3
//
    class Solution {

        public String crackSafe(int n, int k) {
            StringBuilder sb = new StringBuilder();
            int total = (int) (Math.pow(k, n));
            for (int i = 0; i < n; i++) sb.append('0');

            Set<String> visited = new HashSet<>();
            visited.add(sb.toString());
            if (dfs(sb, visited, total, n, k)) {
                return sb.toString();
            } else {
                return "";
            }
        }

        public boolean dfs(StringBuilder b, Set<String> v, int total, int n, int k) {
            if (v.size() == total) return true;
            // try next node
            for (int i = 0; i < k; i++) {
                b.append(i);
                String next = b.substring(b.length() - n);
                if (!v.contains(next)) {
                    v.add(next);
                    if (dfs(b, v, total, n, k)) return true;
                    v.remove(next);
                }
                b.deleteCharAt(b.length() - 1);
            }
            return false;
        }
    }
}
