package LC.SOL;

import java.util.Arrays;

public class LongestUncommonSubsequenceII {
    public class Solution {
        public int findLUSlength(String[] strs) {
            Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());

            int n = strs.length;
            for (int i = 0; i < n; i++) {
                int subseq = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j && isSubSeq(strs[i], strs[j])) {
                        subseq++;
                    }
                }
                if (subseq == 0) return strs[i].length();
            }
            return -1;
        }

        boolean isSubSeq(String s1, String s2) {
            int i = 0, m = s1.length(), n = s2.length();
            for (int j = 0; i < m && j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) i++;
            }
            return i == s1.length();
        }
    }
}
