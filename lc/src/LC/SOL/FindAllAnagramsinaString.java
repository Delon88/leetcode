package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {
    public class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ret = new ArrayList<>();
            int[] hash = new int[256];
            if (s == null || s.length() == 0 || p == null || p.length() == 0) return ret;
            for (int i = 0; i < p.length(); i++) {
                hash[p.charAt(i)]++;
            }

            int start = 0, end = 0, count = 0;
            while (end < s.length()) {
                if (hash[s.charAt(end)] >= 1) count++;
                hash[s.charAt(end)]--;
                end++;

                if (count == p.length()) {
                    ret.add(start);
                }
                if (end - start == p.length()) {
                    if (hash[s.charAt(start)] >= 0) {
                        count--;
                    }
                    hash[s.charAt(start)]++;
                    start++;
                }
            }
            return ret;
        }
    }
}
